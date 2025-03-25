package mx.bank.ms.currency_exchange.adapters.web.mappers;

import mx.bank.ms.currency_exchange.adapters.web.resources.RetrieveCurrencyExchangeTransactionResponse;
import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RetrieveCurrencyExchangeTransactionMapper {

    RetrieveCurrencyExchangeTransactionMapper INSTANCE = Mappers.getMapper( RetrieveCurrencyExchangeTransactionMapper.class );

    RetrieveCurrencyExchangeTransactionResponse toResource(CurrencyExchangeTransactionModel currencyExchangeTransactionModel);

}
