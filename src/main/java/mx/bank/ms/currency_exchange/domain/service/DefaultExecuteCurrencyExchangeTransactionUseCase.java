package mx.bank.ms.currency_exchange.domain.service;

import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModel;
import mx.bank.ms.currency_exchange.domain.usecases.ExecuteCurrencyExchangeTransactionUseCase;
import org.springframework.stereotype.Service;

@Service
public class DefaultExecuteCurrencyExchangeTransactionUseCase implements ExecuteCurrencyExchangeTransactionUseCase {
    @Override
    public CurrencyExchangeTransactionModel execute(CurrencyExchangeTransactionModel currencyExchangeTransactionModel) {
        return null;
    }
}
