package mx.bank.ms.currency_exchange.domain.service;

import mx.bank.ms.currency_exchange.domain.mapper.CurrencyExchangeTransactionModelMapper;
import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModel;
import mx.bank.ms.currency_exchange.domain.model.TransactionStatusModel;
import mx.bank.ms.currency_exchange.domain.usecases.ExecuteCurrencyExchangeTransactionUseCase;
import mx.bank.ms.currency_exchange.infrastructure.persistence.entity.CurrencyExchangeTransactionEntity;
import mx.bank.ms.currency_exchange.infrastructure.persistence.repository.CurrencyExchangeRepository;
import org.springframework.stereotype.Service;

@Service
public class DefaultExecuteCurrencyExchangeTransactionUseCase implements ExecuteCurrencyExchangeTransactionUseCase {

    private final CurrencyExchangeRepository currencyExchangeRepository;

    public DefaultExecuteCurrencyExchangeTransactionUseCase(CurrencyExchangeRepository currencyExchangeRepository) {
        this.currencyExchangeRepository = currencyExchangeRepository;
    }

    @Override
    public CurrencyExchangeTransactionModel execute(CurrencyExchangeTransactionModel currencyExchangeTransactionModel) {
        CurrencyExchangeTransactionEntity currencyExchangeTransactionEntityFind = currencyExchangeRepository
                .findById(currencyExchangeTransactionModel.id())
                .orElseThrow();

        CurrencyExchangeTransactionModel currencyExchangeTransactionModelFind = CurrencyExchangeTransactionModelMapper
                .INSTANCE
                .toModel(currencyExchangeTransactionEntityFind);

        if(currencyExchangeTransactionModelFind.status() == TransactionStatusModel.CANCELLED) {
            throw new RuntimeException(String.format("Invalid status %s", currencyExchangeTransactionModelFind.status()));
        }

        if(currencyExchangeTransactionModelFind.status() == TransactionStatusModel.EXECUTED) {
            throw new RuntimeException(String.format("Invalid status %s", currencyExchangeTransactionModelFind.status()));
        }

        currencyExchangeTransactionEntityFind.setStatus(TransactionStatusModel.EXECUTED.toString());

        CurrencyExchangeTransactionEntity currencyExchangeTransactionUpdated = currencyExchangeRepository.save(currencyExchangeTransactionEntityFind);

        return CurrencyExchangeTransactionModelMapper
                .INSTANCE
                .toModel(currencyExchangeTransactionUpdated);
    }
}
