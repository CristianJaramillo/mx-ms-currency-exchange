package mx.bank.ms.currency_exchange.domain.usecases;

import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModel;

public interface UpdateCurrencyExchangeTransactionUseCase {
    CurrencyExchangeTransactionModel update(CurrencyExchangeTransactionModel currencyExchangeTransactionModel);
}
