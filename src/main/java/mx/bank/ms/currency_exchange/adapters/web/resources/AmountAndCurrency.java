package mx.bank.ms.currency_exchange.adapters.web.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import mx.bank.ms.currency_exchange.adapters.web.resources.serializer.BigDecimalFourDigitsSerializer;

import java.math.BigDecimal;

/**
 * AmountAndCurrency
 */
public record AmountAndCurrency(

        @JsonProperty("amount")
        @JsonSerialize(using = BigDecimalFourDigitsSerializer.class)
        BigDecimal amount,

        @JsonProperty("currency")
        String currency

) {}