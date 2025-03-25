package mx.bank.ms.currency_exchange.infrastructure.external.exchangerateapi;

import mx.bank.ms.currency_exchange.infrastructure.external.exchangerateapi.resources.ExchangeRateLatestResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "${exchange.rate.api.name}",
        url = "${exchange.rate.api.url}",
        configuration = ExchangeRateAPIConfiguration.class
)
public interface ExchangeRateApiClient {
    @GetMapping("/v6/{apiKey}/latest/{currencyCode}")
    ExchangeRateLatestResponse getLatestV6(
            @PathVariable("apiKey") String apiKey,
            @PathVariable("currencyCode") String currencyCode
    );
}
