package mx.bank.ms.currency_exchange;

import mx.bank.ms.currency_exchange.infrastructure.external.exchangerateapi.ExchangeRateApiProperties;
import mx.bank.ms.currency_exchange.infrastructure.messaging.config.RabbitMqProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "mx.bank.ms.currency_exchange.infrastructure.external")
@EnableConfigurationProperties({
		ExchangeRateApiProperties.class,
		RabbitMqProperties.class
})
public class MsCurrencyExchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCurrencyExchangeApplication.class, args);
	}

}
