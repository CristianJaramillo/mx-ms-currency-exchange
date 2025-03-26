package mx.bank.ms.currency_exchange.domain.service;

import mx.bank.ms.currency_exchange.domain.mapper.CurrencyExchangeTransactionModelMapper;
import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModel;
import mx.bank.ms.currency_exchange.domain.usecases.RetrieveCurrencyExchangeTransactionUseCase;
import mx.bank.ms.currency_exchange.infrastructure.persistence.entity.CurrencyExchangeTransactionEntity;
import mx.bank.ms.currency_exchange.infrastructure.persistence.repository.CurrencyExchangeRepository;
import org.springframework.stereotype.Service;

@Service
public class DefaultRetrieveCurrencyExchangeTransactionUseCase implements RetrieveCurrencyExchangeTransactionUseCase {

    private final CurrencyExchangeRepository currencyExchangeRepository;

    public DefaultRetrieveCurrencyExchangeTransactionUseCase(CurrencyExchangeRepository currencyExchangeRepository) {
        this.currencyExchangeRepository = currencyExchangeRepository;
    }


    @Override
    public CurrencyExchangeTransactionModel retrieve(String transactionId) {

        CurrencyExchangeTransactionEntity currencyExchangeTransactionEntity = currencyExchangeRepository
                .findById(transactionId)
                .orElseThrow();

        return CurrencyExchangeTransactionModelMapper
                .INSTANCE
                .toModel(currencyExchangeTransactionEntity);
    }
}
