package mx.bank.ms.currency_exchange.adapters.web.resources;

import java.util.List;

public record ProjectInitializationAgentResponse(String id, String status, String type, Project project, List<Attachment> attachments) {}
