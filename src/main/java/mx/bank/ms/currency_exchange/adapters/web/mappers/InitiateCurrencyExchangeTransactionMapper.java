package mx.bank.ms.currency_exchange.adapters.web.mappers;

import mx.bank.ms.currency_exchange.adapters.web.resources.InitiateCurrencyExchangeTransactionRequest;
import mx.bank.ms.currency_exchange.adapters.web.resources.InitiateCurrencyExchangeTransactionResponse;
import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InitiateCurrencyExchangeTransactionMapper {

    InitiateCurrencyExchangeTransactionMapper INSTANCE = Mappers.getMapper( InitiateCurrencyExchangeTransactionMapper.class );

    CurrencyExchangeTransactionModel toModel(InitiateCurrencyExchangeTransactionRequest initiateCurrencyExchangeTransactionRequest);

    InitiateCurrencyExchangeTransactionResponse toResource(CurrencyExchangeTransactionModel currencyExchangeTransactionModel);

}
