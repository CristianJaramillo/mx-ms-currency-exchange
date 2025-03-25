package mx.bank.ms.currency_exchange.adapters.web.resources;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

import java.math.BigDecimal;

/**
 * ExecuteCurrencyExchangeTransactionResponse
 */

public record ExecuteCurrencyExchangeTransactionResponse(

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

        @JsonProperty("buyAmountAndCurrency")
        @JsonInclude(JsonInclude.Include.NON_ABSENT)
        @JsonSetter(nulls = Nulls.FAIL)
        AmountAndCurrency buyAmountAndCurrency,

        @JsonProperty("sellAmountAndCurrency")
        @JsonInclude(JsonInclude.Include.NON_ABSENT)
        @JsonSetter(nulls = Nulls.FAIL)
        AmountAndCurrency sellAmountAndCurrency,

        @JsonProperty("resultingAmount")
        @JsonInclude(JsonInclude.Include.NON_ABSENT)
        @JsonSetter(nulls = Nulls.FAIL)
        BigDecimal resultingAmount,

        @JsonProperty("createdAt")
        String createdAt,

        @JsonProperty("updatedAt")
        String updatedAt

) {}