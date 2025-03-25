package mx.bank.ms.currency_exchange.adapters.web.mappers;

import mx.bank.ms.currency_exchange.adapters.web.resources.AmountAndCurrency;
import mx.bank.ms.currency_exchange.adapters.web.resources.InitiateCurrencyExchangeTransactionRequest;
import mx.bank.ms.currency_exchange.adapters.web.resources.InitiateCurrencyExchangeTransactionResponse;
import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;

@Mapper(componentModel = "spring", uses = AmountAndCurrencyMapperHelper.class)
public interface InitiateCurrencyExchangeTransactionMapper {

    InitiateCurrencyExchangeTransactionMapper INSTANCE = Mappers.getMapper( InitiateCurrencyExchangeTransactionMapper.class );


    CurrencyExchangeTransactionModel toModel(InitiateCurrencyExchangeTransactionRequest initiateCurrencyExchangeTransactionRequest);

    @Mappings({
            @Mapping(target = "buyAmountAndCurrency", expression = "java(AmountAndCurrencyMapperHelper.toAmountAndCurrency(currencyExchangeTransactionModel.buyAmount(), currencyExchangeTransactionModel.buyCurrency()))"),
            @Mapping(target = "sellAmountAndCurrency", expression = "java(AmountAndCurrencyMapperHelper.toAmountAndCurrency(currencyExchangeTransactionModel.sellAmount(), currencyExchangeTransactionModel.sellCurrency()))")
    })
    InitiateCurrencyExchangeTransactionResponse toResource(CurrencyExchangeTransactionModel currencyExchangeTransactionModel);


}
