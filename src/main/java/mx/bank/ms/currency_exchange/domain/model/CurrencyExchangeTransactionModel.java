package mx.bank.ms.currency_exchange.domain.model;

import lombok.*;

import java.math.BigDecimal;

public record CurrencyExchangeTransactionModel(
        String id,
        TransactionStatusModel status,
        BigDecimal originalAmount,
        String sourceCurrency,
        String targetCurrency,
        BigDecimal buyAmount,
        String buyCurrency,
        BigDecimal sellAmount,
        String sellCurrency,
        BigDecimal resultingAmount,
        String createdAt,
        String updatedAt
) {}
