package mx.bank.ms.currency_exchange.domain.service;

import mx.bank.ms.currency_exchange.domain.mapper.CurrencyExchangeTransactionModelMapper;
import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModel;
import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModelBuilder;
import mx.bank.ms.currency_exchange.domain.model.TransactionStatusModel;
import mx.bank.ms.currency_exchange.domain.usecases.InitiateCurrencyExchangeTransactionUseCase;
import mx.bank.ms.currency_exchange.infrastructure.external.exchangerateapi.ExchangeRateApiClient;
import mx.bank.ms.currency_exchange.infrastructure.external.exchangerateapi.ExchangeRateApiProperties;
import mx.bank.ms.currency_exchange.infrastructure.external.exchangerateapi.resources.ExchangeRateLatestResponse;
import mx.bank.ms.currency_exchange.infrastructure.persistence.entity.CurrencyExchangeTransactionEntity;
import mx.bank.ms.currency_exchange.infrastructure.persistence.repository.CurrencyExchangeRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Service
public class DefaultInitiateCurrencyExchangeTransactionUserCase implements InitiateCurrencyExchangeTransactionUseCase {

    private final ExchangeRateApiClient exchangeRateApiClient;
    private final ExchangeRateApiProperties exchangeRateApiProperties;
    private final CurrencyExchangeRepository currencyExchangeRepository;

    public DefaultInitiateCurrencyExchangeTransactionUserCase(ExchangeRateApiClient exchangeRateApiClient, ExchangeRateApiProperties exchangeRateApiProperties, CurrencyExchangeRepository currencyExchangeRepository) {
        this.exchangeRateApiClient = exchangeRateApiClient;
        this.exchangeRateApiProperties = exchangeRateApiProperties;
        this.currencyExchangeRepository = currencyExchangeRepository;
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
                .createdAt(new Date().toString())
                .updatedAt(new Date().toString())
                .build();


        CurrencyExchangeTransactionEntity currencyExchangeTransactionEntity = CurrencyExchangeTransactionModelMapper
                .INSTANCE
                .toEntity(currencyExchangeTransactionModelResult);

        // CurrencyExchangeTransactionEntity currencyExchangeTransactionEntityStore = currencyExchangeRepository.save(currencyExchangeTransactionEntity);

        return CurrencyExchangeTransactionModelMapper
                .INSTANCE.toModel(currencyExchangeTransactionEntity);
    }
}
