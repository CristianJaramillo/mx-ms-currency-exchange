package mx.bank.ms.currency_exchange.infrastructure.persistence.repository;

import mx.bank.ms.currency_exchange.infrastructure.persistence.entity.ProjectInitializationAgentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectInitializationRepository extends JpaRepository<ProjectInitializationAgentEntity, String> {
    // Puedes agregar consultas personalizadas si lo necesitas, por ejemplo:
    // List<ExchangeCurrencyEntity> findByStatus(String status);
}