package mx.bank.ms.currency_exchange.adapters.web.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ControlCurrencyExchangeTransactionRequest
 */
public record ControlCurrencyExchangeTransactionRequest(

        @JsonProperty("id")
        String id,

        @JsonProperty("status")
        TransactionStatus status

) {}
