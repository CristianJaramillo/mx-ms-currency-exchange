package mx.bank.ms.currency_exchange.domain.service;

import mx.bank.ms.currency_exchange.adapters.web.resources.ProjectInitializationAgentRequest;
import mx.bank.ms.currency_exchange.adapters.web.resources.ProjectInitializationAgentResponse;
import mx.bank.ms.currency_exchange.domain.usecases.RetrieveAgentProjectInitializationUseCase;
import mx.bank.ms.currency_exchange.infrastructure.messaging.CreateProjectProducer;
import mx.bank.ms.currency_exchange.infrastructure.persistence.repository.ProjectInitializationRepository;

/**
 *
 */
public class DefaultRetrieveAgentProjectInitializationUseCase implements RetrieveAgentProjectInitializationUseCase {

    private final ProjectInitializationRepository projectInitializationRepository;
    private final CreateProjectProducer createProjectProducer;

    public DefaultRetrieveAgentProjectInitializationUseCase(CreateProjectProducer createProjectProducer, ProjectInitializationRepository projectInitializationRepository) {

        this.createProjectProducer = createProjectProducer;
        this.projectInitializationRepository = projectInitializationRepository;
    }

    @Override
    public ProjectInitializationAgentResponse retrieveAgentProjectInitializationV1(ProjectInitializationAgentRequest projectInitializationAgentRequest) {



        // serializar archivos y guardar archivos en local.storage.input
        // almacenar procesamiento en base de datos
        // mapea la respuesta


        createProjectProducer.currencyExchangeTransactionQueue(null);


        return null;
    }
}
