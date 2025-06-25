package mx.bank.ms.currency_exchange.adapters.web;

import mx.bank.ms.currency_exchange.adapters.web.resources.ProjectInitializationAgentRequest;
import mx.bank.ms.currency_exchange.adapters.web.resources.ProjectInitializationAgentResponse;
import mx.bank.ms.currency_exchange.domain.usecases.RetrieveAgentProjectInitializationUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ProjectInitializationAgentController {

    private final RetrieveAgentProjectInitializationUseCase retrieveAgentProjectInitializationUseCase;

    public ProjectInitializationAgentController(RetrieveAgentProjectInitializationUseCase retrieveAgentProjectInitializationUseCase) {
        this.retrieveAgentProjectInitializationUseCase = retrieveAgentProjectInitializationUseCase;
    }

    @RequestMapping(value = "/v1/agent/project-initialization/{id}",
            produces = { "application/zip" },
            method = RequestMethod.GET)
    ResponseEntity<Void> retrieveAgentProjectInitializationV1(@PathVariable("id") String id) {
        return null;
    }

    @RequestMapping(value = "/v1/agent/project-initialization/{id}/file",
            produces = { "application/zip" },
            method = RequestMethod.GET)
    ResponseEntity<Void> retrieveAgentProjectInitializationFileV1(@PathVariable("id") String id) {
        return null;
    }

    @RequestMapping(value = "/v1/agent/project-initialization",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<ProjectInitializationAgentResponse> createAgentProjectInitializationV1(@Validated @RequestBody ProjectInitializationAgentRequest projectInitializationAgentRequest) {
        return ResponseEntity.ok(retrieveAgentProjectInitializationUseCase.retrieveAgentProjectInitializationV1(projectInitializationAgentRequest));
    }

}
