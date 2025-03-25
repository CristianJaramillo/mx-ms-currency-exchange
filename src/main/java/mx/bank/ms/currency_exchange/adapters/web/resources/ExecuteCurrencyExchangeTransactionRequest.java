package mx.bank.ms.currency_exchange.adapters.web.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ExecuteCurrencyExchangeTransactionRequest
 */
public record ExecuteCurrencyExchangeTransactionRequest(

        @JsonProperty("id")
        String id

) {}
