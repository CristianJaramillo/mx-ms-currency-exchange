package mx.bank.ms.currency_exchange.domain.usecases;

import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModel;

public interface ControlCurrencyExchangeTransactionUseCase {
    CurrencyExchangeTransactionModel control(CurrencyExchangeTransactionModel currencyExchangeTransactionModel);
}
