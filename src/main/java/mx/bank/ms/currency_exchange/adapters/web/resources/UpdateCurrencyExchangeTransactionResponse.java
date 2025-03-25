package mx.bank.ms.currency_exchange.adapters.web.resources;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * UpdateCurrencyExchangeTransactionResponse
 */
public record UpdateCurrencyExchangeTransactionResponse(

        @JsonProperty("id")
        String id,

        @JsonProperty("status")
        TransactionStatus status,

        @JsonProperty("originalAmount")
        BigDecimal originalAmount,

        @JsonProperty("sourceCurrency")
        String sourceCurrency,

        @JsonProperty("targetCurrency")
        String targetCurrency,

        @JsonProperty("createdAt")
        String createdAt,

        @JsonProperty("updatedAt")
        String updatedAt

) {}