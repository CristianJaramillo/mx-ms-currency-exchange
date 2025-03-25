package mx.bank.ms.currency_exchange.adapters.web.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * AmountAndCurrency
 */
public record AmountAndCurrency(

        @JsonProperty("amount")
        BigDecimal amount,

        @JsonProperty("currency")
        String currency

) {}