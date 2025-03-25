package mx.bank.ms.currency_exchange.domain.service;

import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModel;
import mx.bank.ms.currency_exchange.domain.usecases.UpdateCurrencyExchangeTransactionUseCase;
import org.springframework.stereotype.Service;

@Service
public class DefaultUpdateCurrencyExchangeTransactionUseCase implements UpdateCurrencyExchangeTransactionUseCase {
    @Override
    public CurrencyExchangeTransactionModel update(CurrencyExchangeTransactionModel currencyExchangeTransactionModel) {
        return null;
    }
}
