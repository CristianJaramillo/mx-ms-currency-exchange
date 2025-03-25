package mx.bank.ms.currency_exchange.domain.service;

import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModel;
import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModelBuilder;
import mx.bank.ms.currency_exchange.domain.model.TransactionStatusModel;
import mx.bank.ms.currency_exchange.domain.usecases.UpdateCurrencyExchangeTransactionUseCase;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DefaultUpdateCurrencyExchangeTransactionUseCase implements UpdateCurrencyExchangeTransactionUseCase {
    @Override
    public CurrencyExchangeTransactionModel update(CurrencyExchangeTransactionModel currencyExchangeTransactionModel) {
        return CurrencyExchangeTransactionModelBuilder
                .from(currencyExchangeTransactionModel)
                .status(TransactionStatusModel.INITIATED)
                .updatedAt(new Date().toString())
                .build();
    }
}
