package mx.bank.ms.currency_exchange.adapters.web.resources;

import java.util.List;

public record ProjectInitializationAgentRequest(String type, Project project, List<Attachment> attachments) {}
