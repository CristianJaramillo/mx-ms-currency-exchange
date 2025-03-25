package mx.bank.ms.currency_exchange.adapters.web.mappers;

import mx.bank.ms.currency_exchange.adapters.web.resources.ControlCurrencyExchangeTransactionRequest;
import mx.bank.ms.currency_exchange.adapters.web.resources.ControlCurrencyExchangeTransactionResponse;
import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ControlCurrencyExchangeTransactionMapper {

    ControlCurrencyExchangeTransactionMapper INSTANCE = Mappers.getMapper( ControlCurrencyExchangeTransactionMapper.class );

    CurrencyExchangeTransactionModel toModel(ControlCurrencyExchangeTransactionRequest controlCurrencyExchangeTransactionRequest);

    ControlCurrencyExchangeTransactionResponse toResource(CurrencyExchangeTransactionModel currencyExchangeTransactionModel);
}
