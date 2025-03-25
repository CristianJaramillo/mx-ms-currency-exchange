package mx.bank.ms.currency_exchange.domain.service;

import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModel;
import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModelBuilder;
import mx.bank.ms.currency_exchange.domain.model.TransactionStatusModel;
import mx.bank.ms.currency_exchange.domain.usecases.ExecuteCurrencyExchangeTransactionUseCase;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class DefaultExecuteCurrencyExchangeTransactionUseCase implements ExecuteCurrencyExchangeTransactionUseCase {
    @Override
    public CurrencyExchangeTransactionModel execute(CurrencyExchangeTransactionModel currencyExchangeTransactionModel) {
        return CurrencyExchangeTransactionModelBuilder
                .from(currencyExchangeTransactionModel)
                .status(TransactionStatusModel.EXECUTED)
                .originalAmount(new BigDecimal("1000.00"))
                .sourceCurrency("MXN")
                .targetCurrency("USD")
                .buyCurrency("MXN")
                .buyAmount(new BigDecimal("1000.00"))
                .sellCurrency("USD")
                .sellAmount(new BigDecimal("50.00"))
                .resultingAmount(new BigDecimal("50.00"))
                .createdAt(new Date().toString())
                .updatedAt(new Date().toString())
                .build();
    }
}
