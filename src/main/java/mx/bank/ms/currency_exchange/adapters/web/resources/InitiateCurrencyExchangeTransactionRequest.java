package mx.bank.ms.currency_exchange.adapters.web.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * InitiateCurrencyExchangeTransactionRequest
 */
public record InitiateCurrencyExchangeTransactionRequest(

        @JsonProperty("originalAmount")
        BigDecimal originalAmount,

        @JsonProperty("sourceCurrency")
        String sourceCurrency,

        @JsonProperty("targetCurrency")
        String targetCurrency

) {}