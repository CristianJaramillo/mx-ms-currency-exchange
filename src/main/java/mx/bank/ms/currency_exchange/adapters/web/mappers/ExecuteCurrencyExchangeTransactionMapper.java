package mx.bank.ms.currency_exchange.adapters.web.mappers;

import mx.bank.ms.currency_exchange.adapters.web.resources.ExecuteCurrencyExchangeTransactionRequest;
import mx.bank.ms.currency_exchange.adapters.web.resources.ExecuteCurrencyExchangeTransactionResponse;
import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = AmountAndCurrencyMapperHelper.class)
public interface ExecuteCurrencyExchangeTransactionMapper {
    ExecuteCurrencyExchangeTransactionMapper INSTANCE = Mappers.getMapper( ExecuteCurrencyExchangeTransactionMapper.class );

    CurrencyExchangeTransactionModel toModel(ExecuteCurrencyExchangeTransactionRequest executeCurrencyExchangeTransactionRequest);

    @Mappings({
            @Mapping(target = "buyAmountAndCurrency", expression = "java(AmountAndCurrencyMapperHelper.toAmountAndCurrency(currencyExchangeTransactionModel.buyAmount(), currencyExchangeTransactionModel.buyCurrency()))"),
            @Mapping(target = "sellAmountAndCurrency", expression = "java(AmountAndCurrencyMapperHelper.toAmountAndCurrency(currencyExchangeTransactionModel.sellAmount(), currencyExchangeTransactionModel.sellCurrency()))")
    })
    ExecuteCurrencyExchangeTransactionResponse toResource(CurrencyExchangeTransactionModel currencyExchangeTransactionModel);
}
