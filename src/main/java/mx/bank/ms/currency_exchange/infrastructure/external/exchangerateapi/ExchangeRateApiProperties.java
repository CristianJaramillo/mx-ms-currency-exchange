package mx.bank.ms.currency_exchange.infrastructure.external.exchangerateapi;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "exchange.rate.api")
public record ExchangeRateApiProperties(
        String name,
        String url,
        String apiKey
) {}