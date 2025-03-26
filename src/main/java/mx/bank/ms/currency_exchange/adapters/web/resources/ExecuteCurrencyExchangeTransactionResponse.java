package mx.bank.ms.currency_exchange.adapters.web.resources;

import com.fasterxml.jackson.annotation.*;

import java.math.BigDecimal;
import java.util.Date;

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
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone = "UTC")
        Date createdAt,

        @JsonProperty("updatedAt")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone = "UTC")
        Date updatedAt

) {}