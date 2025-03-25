package mx.bank.ms.currency_exchange.adapters.web.mappers;

import mx.bank.ms.currency_exchange.adapters.web.resources.ControlCurrencyExchangeTransactionRequest;
import mx.bank.ms.currency_exchange.adapters.web.resources.ControlCurrencyExchangeTransactionResponse;
import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = AmountAndCurrencyMapperHelper.class)
public interface ControlCurrencyExchangeTransactionMapper {

    ControlCurrencyExchangeTransactionMapper INSTANCE = Mappers.getMapper( ControlCurrencyExchangeTransactionMapper.class );

    CurrencyExchangeTransactionModel toModel(ControlCurrencyExchangeTransactionRequest controlCurrencyExchangeTransactionRequest);

    @Mappings({
            @Mapping(target = "buyAmountAndCurrency", expression = "java(AmountAndCurrencyMapperHelper.toAmountAndCurrency(currencyExchangeTransactionModel.buyAmount(), currencyExchangeTransactionModel.buyCurrency()))"),
            @Mapping(target = "sellAmountAndCurrency", expression = "java(AmountAndCurrencyMapperHelper.toAmountAndCurrency(currencyExchangeTransactionModel.sellAmount(), currencyExchangeTransactionModel.sellCurrency()))")
    })
    ControlCurrencyExchangeTransactionResponse toResource(CurrencyExchangeTransactionModel currencyExchangeTransactionModel);
}
