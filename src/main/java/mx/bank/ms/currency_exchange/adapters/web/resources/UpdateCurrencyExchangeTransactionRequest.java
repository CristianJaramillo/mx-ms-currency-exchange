package mx.bank.ms.currency_exchange.adapters.web.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/**
 * UpdateCurrencyExchangeTransactionRequest
 */
public record UpdateCurrencyExchangeTransactionRequest(

        @JsonProperty("id")
        String id,

        @JsonProperty("originalAmount")
        BigDecimal originalAmount,

        @JsonProperty("sourceCurrency")
        String sourceCurrency,

        @JsonProperty("targetCurrency")
        String targetCurrency

) {}