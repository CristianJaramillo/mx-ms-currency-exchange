package mx.bank.ms.currency_exchange.domain.mapper;

import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModel;
import mx.bank.ms.currency_exchange.infrastructure.messaging.message.TransactionMessage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Mapper(componentModel = "spring", uses = AmountAndCurrencyMessageMapperHelper.class)
public interface CurrencyExchangeTransactionMessageMapper {
    CurrencyExchangeTransactionMessageMapper INSTANCE = Mappers.getMapper(CurrencyExchangeTransactionMessageMapper.class );

    @Mappings({
            @Mapping(target = "buyAmountAndCurrency", expression = "java(AmountAndCurrencyMessageMapperHelper.toAmountAndCurrency(currencyExchangeTransactionModel.buyAmount(), currencyExchangeTransactionModel.buyCurrency()))"),
            @Mapping(target = "sellAmountAndCurrency", expression = "java(AmountAndCurrencyMessageMapperHelper.toAmountAndCurrency(currencyExchangeTransactionModel.sellAmount(), currencyExchangeTransactionModel.sellCurrency()))")
    })
    TransactionMessage toMessage(CurrencyExchangeTransactionModel currencyExchangeTransactionModel);


    CurrencyExchangeTransactionModel toModel(TransactionMessage message);

    // Funciones auxiliares
    default LocalDateTime toLocalDateTime(Date date) {
        return date == null ? null : date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    default Date toDate(LocalDateTime localDateTime) {
        return localDateTime == null ? null : Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
