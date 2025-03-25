package mx.bank.ms.currency_exchange.adapters.web.mappers;

import mx.bank.ms.currency_exchange.adapters.web.resources.AmountAndCurrency;

import java.math.BigDecimal;

public class AmountAndCurrencyMapperHelper {

    public static AmountAndCurrency toAmountAndCurrency(BigDecimal amount, String currency) {
        if (amount == null || currency == null) {
            return null;
        }
        return new AmountAndCurrency(amount, currency);
    }

}
