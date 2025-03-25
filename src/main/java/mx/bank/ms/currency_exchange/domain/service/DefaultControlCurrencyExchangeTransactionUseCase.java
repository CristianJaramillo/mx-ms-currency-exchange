package mx.bank.ms.currency_exchange.domain.service;

import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModel;
import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModelBuilder;
import mx.bank.ms.currency_exchange.domain.model.TransactionStatusModel;
import mx.bank.ms.currency_exchange.domain.usecases.ControlCurrencyExchangeTransactionUseCase;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class DefaultControlCurrencyExchangeTransactionUseCase implements ControlCurrencyExchangeTransactionUseCase {
    @Override
    public CurrencyExchangeTransactionModel control(CurrencyExchangeTransactionModel currencyExchangeTransactionModel) {

        return CurrencyExchangeTransactionModelBuilder
                .from(currencyExchangeTransactionModel)
                .status(TransactionStatusModel.CANCELLED)
                .originalAmount(new BigDecimal("1000.00"))
                .sourceCurrency("MXN")
                .targetCurrency("USD")
                .createdAt(new Date().toString())
                .updatedAt(new Date().toString())
                .build();
    }
}
