package mx.bank.ms.currency_exchange.adapters.web.mappers;

import mx.bank.ms.currency_exchange.adapters.web.resources.ExecuteCurrencyExchangeTransactionRequest;
import mx.bank.ms.currency_exchange.adapters.web.resources.ExecuteCurrencyExchangeTransactionResponse;
import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExecuteCurrencyExchangeTransactionMapper {
    ExecuteCurrencyExchangeTransactionMapper INSTANCE = Mappers.getMapper( ExecuteCurrencyExchangeTransactionMapper.class );

    CurrencyExchangeTransactionModel toModel(ExecuteCurrencyExchangeTransactionRequest executeCurrencyExchangeTransactionRequest);

    ExecuteCurrencyExchangeTransactionResponse toResource(CurrencyExchangeTransactionModel currencyExchangeTransactionModel);
}
