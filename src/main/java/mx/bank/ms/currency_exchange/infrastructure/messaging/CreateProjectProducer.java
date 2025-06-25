package mx.bank.ms.currency_exchange.infrastructure.messaging;

import mx.bank.ms.currency_exchange.adapters.web.resources.ProjectInitializationAgentResponse;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CreateProjectProducer {
    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    public CreateProjectProducer(RabbitTemplate rabbitTemplate, Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }

    /**
     *
     * @param projectInitializationAgentResponse
     */
    public void currencyExchangeTransactionQueue(@Payload ProjectInitializationAgentResponse projectInitializationAgentResponse) {
        rabbitTemplate.convertAndSend(queue.getName(), projectInitializationAgentResponse);
    }

}
