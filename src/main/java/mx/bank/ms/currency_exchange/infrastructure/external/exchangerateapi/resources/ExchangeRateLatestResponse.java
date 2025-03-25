package mx.bank.ms.currency_exchange.infrastructure.external.exchangerateapi.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public record ExchangeRateLatestResponse(

        @JsonProperty("result")
        String result,

        @JsonProperty("documentation")
        String documentation,

        @JsonProperty("terms_of_use")
        String termsOfUse,

        @JsonProperty("time_last_update_unix")
        long timeLastUpdateUnix,

        @JsonProperty("time_last_update_utc")
        String timeLastUpdateUtc,

        @JsonProperty("time_next_update_unix")
        long timeNextUpdateUnix,

        @JsonProperty("time_next_update_utc")
        String timeNextUpdateUtc,

        @JsonProperty("base_code")
        String baseCode,

        @JsonProperty("error-type")
        String error_type,

        @JsonProperty("conversion_rates")
        Map<String, Double> conversionRates

) {}