package mx.bank.ms.currency_exchange.domain.service;

import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModel;
import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModelBuilder;
import mx.bank.ms.currency_exchange.domain.model.TransactionStatusModel;
import mx.bank.ms.currency_exchange.domain.usecases.RetrieveCurrencyExchangeTransactionUseCase;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class DefaultRetrieveCurrencyExchangeTransactionUseCase implements RetrieveCurrencyExchangeTransactionUseCase {
    @Override
    public CurrencyExchangeTransactionModel retrieve(String transactionId) {
        return new CurrencyExchangeTransactionModelBuilder()
                .id(transactionId)
                .status(TransactionStatusModel.INITIATED)
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
