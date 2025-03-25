package mx.bank.ms.currency_exchange.adapters.web.resources;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * InitiateCurrencyExchangeTransactionResponse
 */
public record InitiateCurrencyExchangeTransactionResponse(

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