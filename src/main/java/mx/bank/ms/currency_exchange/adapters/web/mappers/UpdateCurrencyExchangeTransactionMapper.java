package mx.bank.ms.currency_exchange.adapters.web.mappers;

import mx.bank.ms.currency_exchange.adapters.web.resources.UpdateCurrencyExchangeTransactionRequest;
import mx.bank.ms.currency_exchange.adapters.web.resources.UpdateCurrencyExchangeTransactionResponse;
import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UpdateCurrencyExchangeTransactionMapper {

    UpdateCurrencyExchangeTransactionMapper INSTANCE = Mappers.getMapper( UpdateCurrencyExchangeTransactionMapper.class );

    CurrencyExchangeTransactionModel toModel(UpdateCurrencyExchangeTransactionRequest updateCurrencyExchangeTransactionRequest);

    UpdateCurrencyExchangeTransactionResponse toResource(CurrencyExchangeTransactionModel currencyExchangeTransactionModel);
}
