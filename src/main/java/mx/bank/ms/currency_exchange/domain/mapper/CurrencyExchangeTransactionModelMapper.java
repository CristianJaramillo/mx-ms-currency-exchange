package mx.bank.ms.currency_exchange.domain.mapper;

import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModel;
import mx.bank.ms.currency_exchange.infrastructure.persistence.entity.CurrencyExchangeTransactionEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface CurrencyExchangeTransactionModelMapper {

    CurrencyExchangeTransactionModelMapper INSTANCE = Mappers.getMapper(CurrencyExchangeTransactionModelMapper.class);

    CurrencyExchangeTransactionEntity toEntity(CurrencyExchangeTransactionModel model);

    CurrencyExchangeTransactionModel toModel(CurrencyExchangeTransactionEntity entity);

    // Helpers
    default LocalDateTime parseDate(String value) {
        return value == null ? null : LocalDateTime.parse(value, DateTimeFormatter.ISO_DATE_TIME);
    }

    default String formatDate(LocalDateTime date) {
        return date == null ? null : date.format(DateTimeFormatter.ISO_DATE_TIME);
    }
}