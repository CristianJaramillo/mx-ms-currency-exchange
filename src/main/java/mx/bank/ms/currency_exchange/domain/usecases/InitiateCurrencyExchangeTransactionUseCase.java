package mx.bank.ms.currency_exchange.domain.usecases;

import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModel;

public interface InitiateCurrencyExchangeTransactionUseCase {
    CurrencyExchangeTransactionModel initiate(CurrencyExchangeTransactionModel currencyExchangeTransactionModel);
}
