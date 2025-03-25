package mx.bank.ms.currency_exchange.adapters.web.mappers;

import mx.bank.ms.currency_exchange.adapters.web.resources.UpdateCurrencyExchangeTransactionRequest;
import mx.bank.ms.currency_exchange.adapters.web.resources.UpdateCurrencyExchangeTransactionResponse;
import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = AmountAndCurrencyMapperHelper.class)
public interface UpdateCurrencyExchangeTransactionMapper {

    UpdateCurrencyExchangeTransactionMapper INSTANCE = Mappers.getMapper( UpdateCurrencyExchangeTransactionMapper.class );

    CurrencyExchangeTransactionModel toModel(UpdateCurrencyExchangeTransactionRequest updateCurrencyExchangeTransactionRequest);

    @Mappings({
            @Mapping(target = "buyAmountAndCurrency", expression = "java(AmountAndCurrencyMapperHelper.toAmountAndCurrency(currencyExchangeTransactionModel.buyAmount(), currencyExchangeTransactionModel.buyCurrency()))"),
            @Mapping(target = "sellAmountAndCurrency", expression = "java(AmountAndCurrencyMapperHelper.toAmountAndCurrency(currencyExchangeTransactionModel.sellAmount(), currencyExchangeTransactionModel.sellCurrency()))")
    })
    UpdateCurrencyExchangeTransactionResponse toResource(CurrencyExchangeTransactionModel currencyExchangeTransactionModel);
}
