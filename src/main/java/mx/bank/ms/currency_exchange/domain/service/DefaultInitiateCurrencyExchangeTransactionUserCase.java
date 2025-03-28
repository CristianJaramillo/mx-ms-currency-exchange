package mx.bank.ms.currency_exchange.domain.service;

import jakarta.persistence.PersistenceException;
import mx.bank.ms.currency_exchange.domain.mapper.CurrencyExchangeTransactionMessageMapper;
import mx.bank.ms.currency_exchange.domain.mapper.CurrencyExchangeTransactionModelMapper;
import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModel;
import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModelBuilder;
import mx.bank.ms.currency_exchange.domain.model.TransactionStatusModel;
import mx.bank.ms.currency_exchange.domain.usecases.InitiateCurrencyExchangeTransactionUseCase;
import mx.bank.ms.currency_exchange.infrastructure.external.exchangerateapi.ExchangeRateApiClient;
import mx.bank.ms.currency_exchange.infrastructure.external.exchangerateapi.ExchangeRateApiProperties;
import mx.bank.ms.currency_exchange.infrastructure.external.exchangerateapi.resources.ExchangeRateLatestResponse;
import mx.bank.ms.currency_exchange.infrastructure.messaging.CurrencyExchangeTransactionProducer;
import mx.bank.ms.currency_exchange.infrastructure.messaging.message.CurrencyExchangeTransactionMessage;
import mx.bank.ms.currency_exchange.infrastructure.persistence.entity.CurrencyExchangeTransactionEntity;
import mx.bank.ms.currency_exchange.infrastructure.persistence.repository.CurrencyExchangeRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.CannotCreateTransactionException;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Service
public class DefaultInitiateCurrencyExchangeTransactionUserCase implements InitiateCurrencyExchangeTransactionUseCase {

    private final ExchangeRateApiClient exchangeRateApiClient;
    private final ExchangeRateApiProperties exchangeRateApiProperties;
    private final CurrencyExchangeRepository currencyExchangeRepository;
    private final CurrencyExchangeTransactionProducer currencyExchangeTransactionProducer;

    public DefaultInitiateCurrencyExchangeTransactionUserCase(ExchangeRateApiClient exchangeRateApiClient, ExchangeRateApiProperties exchangeRateApiProperties, CurrencyExchangeRepository currencyExchangeRepository, CurrencyExchangeTransactionProducer currencyExchangeTransactionProducer) {
        this.exchangeRateApiClient = exchangeRateApiClient;
        this.exchangeRateApiProperties = exchangeRateApiProperties;
        this.currencyExchangeRepository = currencyExchangeRepository;
        this.currencyExchangeTransactionProducer = currencyExchangeTransactionProducer;
    }

    @Override
    public CurrencyExchangeTransactionModel initiate(CurrencyExchangeTransactionModel currencyExchangeTransactionModel) {

        final ExchangeRateLatestResponse exchangeRateLatestResponse = exchangeRateApiClient.getLatestV6(exchangeRateApiProperties.apiKey(), currencyExchangeTransactionModel.sourceCurrency());

        Double sourceRateDouble = exchangeRateLatestResponse
                .conversionRates()
                .get(currencyExchangeTransactionModel.sourceCurrency().toUpperCase());
        Double targetRateDouble = exchangeRateLatestResponse
                .conversionRates()
                .get(currencyExchangeTransactionModel.targetCurrency().toUpperCase());

        BigDecimal resultingAmount = currencyExchangeTransactionModel
                .originalAmount()
                .multiply(BigDecimal.valueOf(targetRateDouble));

        CurrencyExchangeTransactionModel currencyExchangeTransactionModelResult = CurrencyExchangeTransactionModelBuilder
                .from(currencyExchangeTransactionModel)
                .id(UUID.randomUUID().toString())
                .status(TransactionStatusModel.INITIATED)
                .buyCurrency(currencyExchangeTransactionModel.sourceCurrency())
                .buyAmount(BigDecimal.valueOf(sourceRateDouble))
                .sellCurrency(currencyExchangeTransactionModel.targetCurrency())
                .sellAmount(BigDecimal.valueOf(targetRateDouble))
                .resultingAmount(resultingAmount)
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();

        CurrencyExchangeTransactionEntity currencyExchangeTransactionEntity = CurrencyExchangeTransactionModelMapper
                .INSTANCE
                .toEntity(currencyExchangeTransactionModelResult);

        try {
            CurrencyExchangeTransactionEntity currencyExchangeTransactionEntityStore = currencyExchangeRepository.save(currencyExchangeTransactionEntity);
            return CurrencyExchangeTransactionModelMapper
                    .INSTANCE.toModel(currencyExchangeTransactionEntityStore);
        } catch (CannotCreateTransactionException | DataAccessException | PersistenceException ex) {

            CurrencyExchangeTransactionModel currencyExchangeTransactionModelPending = CurrencyExchangeTransactionModelBuilder
                    .from(currencyExchangeTransactionModelResult)
                    .status(TransactionStatusModel.PENDING)
                    .build();

            CurrencyExchangeTransactionMessage currencyExchangeTransactionMessage = CurrencyExchangeTransactionMessageMapper.INSTANCE.toMessage(currencyExchangeTransactionModelPending);
            currencyExchangeTransactionProducer.currencyExchangeTransactionQueue(currencyExchangeTransactionMessage);

            return currencyExchangeTransactionModelPending;
        }
    }
}
