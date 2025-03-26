package mx.bank.ms.currency_exchange.domain.service;

import mx.bank.ms.currency_exchange.domain.mapper.CurrencyExchangeTransactionModelMapper;
import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModel;
import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModelBuilder;
import mx.bank.ms.currency_exchange.domain.model.TransactionStatusModel;
import mx.bank.ms.currency_exchange.domain.usecases.UpdateCurrencyExchangeTransactionUseCase;
import mx.bank.ms.currency_exchange.infrastructure.external.exchangerateapi.ExchangeRateApiClient;
import mx.bank.ms.currency_exchange.infrastructure.external.exchangerateapi.ExchangeRateApiProperties;
import mx.bank.ms.currency_exchange.infrastructure.external.exchangerateapi.resources.ExchangeRateLatestResponse;
import mx.bank.ms.currency_exchange.infrastructure.persistence.entity.CurrencyExchangeTransactionEntity;
import mx.bank.ms.currency_exchange.infrastructure.persistence.repository.CurrencyExchangeRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DefaultUpdateCurrencyExchangeTransactionUseCase implements UpdateCurrencyExchangeTransactionUseCase {

    private final ExchangeRateApiClient exchangeRateApiClient;
    private final ExchangeRateApiProperties exchangeRateApiProperties;
    private final CurrencyExchangeRepository currencyExchangeRepository;

    public DefaultUpdateCurrencyExchangeTransactionUseCase(ExchangeRateApiClient exchangeRateApiClient, ExchangeRateApiProperties exchangeRateApiProperties, CurrencyExchangeRepository currencyExchangeRepository) {
        this.exchangeRateApiClient = exchangeRateApiClient;
        this.exchangeRateApiProperties = exchangeRateApiProperties;
        this.currencyExchangeRepository = currencyExchangeRepository;
    }


    @Override
    public CurrencyExchangeTransactionModel update(CurrencyExchangeTransactionModel currencyExchangeTransactionModel) {

        CurrencyExchangeTransactionEntity currencyExchangeTransactionEntityFind = currencyExchangeRepository
                .findById(currencyExchangeTransactionModel.id())
                .orElseThrow();

        CurrencyExchangeTransactionModel currencyExchangeTransactionModelFind = CurrencyExchangeTransactionModelMapper
                .INSTANCE
                .toModel(currencyExchangeTransactionEntityFind);

        if(currencyExchangeTransactionModelFind.status() == TransactionStatusModel.CANCELLED || currencyExchangeTransactionModelFind.status() == TransactionStatusModel.EXECUTED) {
            throw new RuntimeException(String.format("Invalid status %s", currencyExchangeTransactionModelFind.status()));
        }

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

        CurrencyExchangeTransactionModel currencyExchangeTransactionModelUpdate = CurrencyExchangeTransactionModelBuilder.from(currencyExchangeTransactionModelFind)
                .status(TransactionStatusModel.INITIATED)
                .originalAmount(currencyExchangeTransactionModel.originalAmount())
                .sourceCurrency(currencyExchangeTransactionModel.sourceCurrency())
                .targetCurrency(currencyExchangeTransactionModel.targetCurrency())
                .buyCurrency(currencyExchangeTransactionModel.sourceCurrency())
                .buyAmount(BigDecimal.valueOf(sourceRateDouble))
                .sellCurrency(currencyExchangeTransactionModel.targetCurrency())
                .sellAmount(BigDecimal.valueOf(targetRateDouble))
                .resultingAmount(resultingAmount)
                .build();

        CurrencyExchangeTransactionEntity currencyExchangeTransactionEntityUpdate = CurrencyExchangeTransactionModelMapper
                .INSTANCE
                .toEntity(currencyExchangeTransactionModelUpdate);

        currencyExchangeRepository.save(currencyExchangeTransactionEntityUpdate);

        return CurrencyExchangeTransactionModelMapper
                .INSTANCE
                .toModel(currencyExchangeTransactionEntityUpdate);


    }
}
