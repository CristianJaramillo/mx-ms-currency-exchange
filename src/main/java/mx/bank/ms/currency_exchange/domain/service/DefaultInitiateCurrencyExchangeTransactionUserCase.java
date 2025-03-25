package mx.bank.ms.currency_exchange.domain.service;

import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModel;
import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModelBuilder;
import mx.bank.ms.currency_exchange.domain.model.TransactionStatusModel;
import mx.bank.ms.currency_exchange.domain.usecases.InitiateCurrencyExchangeTransactionUseCase;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class DefaultInitiateCurrencyExchangeTransactionUserCase implements InitiateCurrencyExchangeTransactionUseCase {
    @Override
    public CurrencyExchangeTransactionModel initiate(CurrencyExchangeTransactionModel currencyExchangeTransactionModel) {
        return CurrencyExchangeTransactionModelBuilder
                .from(currencyExchangeTransactionModel)
                .id(UUID.randomUUID().toString())
                .status(TransactionStatusModel.INITIATED)
                .createdAt(new Date().toString())
                .updatedAt(new Date().toString())
                .build();
    }
}
