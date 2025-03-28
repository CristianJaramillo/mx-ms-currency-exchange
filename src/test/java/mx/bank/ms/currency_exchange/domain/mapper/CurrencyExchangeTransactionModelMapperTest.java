package mx.bank.ms.currency_exchange.domain.mapper;

import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModel;
import mx.bank.ms.currency_exchange.infrastructure.persistence.entity.CurrencyExchangeTransactionEntity;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class CurrencyExchangeTransactionModelMapperTest {

    @Test
    void toEntity() {

    }

    @Test
    void toModel() {

        var entity = new CurrencyExchangeTransactionEntity();
        entity.setId("abc");
        entity.setSourceCurrency("MXN");
        entity.setTargetCurrency("USD");
        entity.setCreatedAt(LocalDateTime.now());

        CurrencyExchangeTransactionModel model = CurrencyExchangeTransactionModelMapper.INSTANCE.toModel(entity);

        System.out.println(entity);
        System.out.println(model);

    }
}