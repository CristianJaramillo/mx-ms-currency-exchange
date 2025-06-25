package mx.bank.ms.currency_exchange.domain.usecases;

import mx.bank.ms.currency_exchange.adapters.web.resources.ProjectInitializationAgentRequest;
import mx.bank.ms.currency_exchange.adapters.web.resources.ProjectInitializationAgentResponse;

public interface RetrieveAgentProjectInitializationUseCase {

    ProjectInitializationAgentResponse retrieveAgentProjectInitializationV1(ProjectInitializationAgentRequest projectInitializationAgentRequest);

}
