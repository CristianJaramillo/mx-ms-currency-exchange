package mx.bank.ms.currency_exchange.infrastructure.messaging;

import mx.bank.ms.currency_exchange.domain.mapper.CurrencyExchangeTransactionMessageMapper;
import mx.bank.ms.currency_exchange.infrastructure.messaging.message.CurrencyExchangeMessage;
import mx.bank.ms.currency_exchange.infrastructure.messaging.message.TransactionMessage;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Date;

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
     * @param transactionMessage
     */
    public void currencyExchangeTransactionQueue(@Payload  TransactionMessage transactionMessage) {
        var currencyExchangeMessage = new CurrencyExchangeMessage(transactionMessage, new Date());
        rabbitTemplate.convertAndSend(queue.getName(), currencyExchangeMessage);
    }
}
