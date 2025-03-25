package mx.bank.ms.currency_exchange.adapters.web.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * AmountAndCurrency
 */
public record AmountAndCurrency(

        @JsonProperty("amount")
        Double amount,

        @JsonProperty("currency")
        String currency

) {}