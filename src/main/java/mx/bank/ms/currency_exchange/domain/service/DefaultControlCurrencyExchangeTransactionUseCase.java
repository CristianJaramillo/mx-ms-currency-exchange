package mx.bank.ms.currency_exchange.domain.service;

import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModel;
import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModelBuilder;
import mx.bank.ms.currency_exchange.domain.model.TransactionStatusModel;
import mx.bank.ms.currency_exchange.domain.usecases.ControlCurrencyExchangeTransactionUseCase;
import org.springframework.stereotype.Service;

@Service
public class DefaultControlCurrencyExchangeTransactionUseCase implements ControlCurrencyExchangeTransactionUseCase {
    @Override
    public CurrencyExchangeTransactionModel control(CurrencyExchangeTransactionModel currencyExchangeTransactionModel) {

        return CurrencyExchangeTransactionModelBuilder
                .from(currencyExchangeTransactionModel)
                .status(TransactionStatusModel.CANCELLED)
                .build();
    }
}
