package mx.bank.ms.currency_exchange.infrastructure.messaging;

import mx.bank.ms.currency_exchange.infrastructure.messaging.message.CurrencyExchangeTransactionMessage;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CurrencyExchangeTransactionProducer {
    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    public CurrencyExchangeTransactionProducer(RabbitTemplate rabbitTemplate, Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }

    /**
     *
     * @param currencyExchangeTransactionMessage
     */
    public void currencyExchangeTransactionQueue(@Payload CurrencyExchangeTransactionMessage currencyExchangeTransactionMessage) {
        rabbitTemplate.convertAndSend(queue.getName(), currencyExchangeTransactionMessage);
    }
}
