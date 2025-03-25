package mx.bank.ms.currency_exchange.adapters.web;

import mx.bank.ms.currency_exchange.adapters.web.mappers.*;
import mx.bank.ms.currency_exchange.adapters.web.resources.*;
import mx.bank.ms.currency_exchange.domain.model.CurrencyExchangeTransactionModel;
import mx.bank.ms.currency_exchange.domain.usecases.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Cristian Jaramillo (cristian_gerar@hotmail.com)
 */
@RestController
@RequestMapping("/customerServices/currencyExchange")
public class BankCurrencyExchangeController {

    private final ControlCurrencyExchangeTransactionUseCase controlCurrencyExchangeTransactionUseCase;
    private final ExecuteCurrencyExchangeTransactionUseCase executeCurrencyExchangeTransactionUseCase;
    private final InitiateCurrencyExchangeTransactionUseCase initiateCurrencyExchangeTransactionUseCase;
    private final RetrieveCurrencyExchangeTransactionUseCase retrieveCurrencyExchangeTransactionUseCase;
    private final UpdateCurrencyExchangeTransactionUseCase updateCurrencyExchangeTransactionUseCase;

    public BankCurrencyExchangeController(
            ControlCurrencyExchangeTransactionUseCase controlCurrencyExchangeTransactionUseCase,
            ExecuteCurrencyExchangeTransactionUseCase executeCurrencyExchangeTransactionUseCase,
            InitiateCurrencyExchangeTransactionUseCase initiateCurrencyExchangeTransactionUseCase,
            RetrieveCurrencyExchangeTransactionUseCase retrieveCurrencyExchangeTransactionUseCase,
            UpdateCurrencyExchangeTransactionUseCase updateCurrencyExchangeTransactionUseCase
    ) {
        this.controlCurrencyExchangeTransactionUseCase = controlCurrencyExchangeTransactionUseCase;
        this.executeCurrencyExchangeTransactionUseCase = executeCurrencyExchangeTransactionUseCase;
        this.initiateCurrencyExchangeTransactionUseCase = initiateCurrencyExchangeTransactionUseCase;
        this.retrieveCurrencyExchangeTransactionUseCase = retrieveCurrencyExchangeTransactionUseCase;
        this.updateCurrencyExchangeTransactionUseCase = updateCurrencyExchangeTransactionUseCase;
    }

    @RequestMapping(value = "/v1/transaction/control",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<ControlCurrencyExchangeTransactionResponse> controleTransactionV1(@Validated @RequestBody ControlCurrencyExchangeTransactionRequest controlCurrencyExchangeTransactionRequest) {
        final CurrencyExchangeTransactionModel currencyExchangeTransactionModel = controlCurrencyExchangeTransactionUseCase.control(ControlCurrencyExchangeTransactionMapper.INSTANCE.toModel(controlCurrencyExchangeTransactionRequest));
        final ControlCurrencyExchangeTransactionResponse controlCurrencyExchangeTransactionResponse = ControlCurrencyExchangeTransactionMapper.INSTANCE.toResource(currencyExchangeTransactionModel);
        return ResponseEntity.ok(controlCurrencyExchangeTransactionResponse);
    }

    @RequestMapping(value = "/v1/transaction/execute",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<ExecuteCurrencyExchangeTransactionResponse> executeTransactionV1(@RequestBody ExecuteCurrencyExchangeTransactionRequest executeCurrencyExchangeTransactionRequest) {
        final CurrencyExchangeTransactionModel currencyExchangeTransactionModel = executeCurrencyExchangeTransactionUseCase.execute(ExecuteCurrencyExchangeTransactionMapper.INSTANCE.toModel(executeCurrencyExchangeTransactionRequest));
        final ExecuteCurrencyExchangeTransactionResponse executeCurrencyExchangeTransactionResponse = ExecuteCurrencyExchangeTransactionMapper.INSTANCE.toResource(currencyExchangeTransactionModel);
        return ResponseEntity.ok(executeCurrencyExchangeTransactionResponse);
    }

    @RequestMapping(value = "/v1/transaction/initiate",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<InitiateCurrencyExchangeTransactionResponse> initiateTransactionV1(@RequestBody InitiateCurrencyExchangeTransactionRequest initiateCurrencyExchangeTransactionRequest) {
        final CurrencyExchangeTransactionModel currencyExchangeTransactionModel = initiateCurrencyExchangeTransactionUseCase.initiate(InitiateCurrencyExchangeTransactionMapper.INSTANCE.toModel(initiateCurrencyExchangeTransactionRequest));
        final InitiateCurrencyExchangeTransactionResponse initiateCurrencyExchangeTransactionResponse = InitiateCurrencyExchangeTransactionMapper.INSTANCE.toResource(currencyExchangeTransactionModel);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(initiateCurrencyExchangeTransactionResponse);
    }

    @RequestMapping(value = "/v1/transaction/{transactionId}/retrieve",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<RetrieveCurrencyExchangeTransactionResponse> retrieveTransactionV1(@PathVariable("transactionId") String transactionId) {
        final CurrencyExchangeTransactionModel currencyExchangeTransactionModel = retrieveCurrencyExchangeTransactionUseCase.retrieve(transactionId);
        final RetrieveCurrencyExchangeTransactionResponse retrieveCurrencyExchangeTransactionResponse = RetrieveCurrencyExchangeTransactionMapper.INSTANCE.toResource(currencyExchangeTransactionModel);
        return ResponseEntity.ok(retrieveCurrencyExchangeTransactionResponse);
    }

    @RequestMapping(value = "/v1/transaction/update",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<UpdateCurrencyExchangeTransactionResponse> updateTransactionV1(@RequestBody UpdateCurrencyExchangeTransactionRequest updateCurrencyExchangeTransactionRequest) {
        final CurrencyExchangeTransactionModel currencyExchangeTransactionModel = updateCurrencyExchangeTransactionUseCase.update(UpdateCurrencyExchangeTransactionMapper.INSTANCE.toModel(updateCurrencyExchangeTransactionRequest));
        final UpdateCurrencyExchangeTransactionResponse updateCurrencyExchangeTransactionResponse = UpdateCurrencyExchangeTransactionMapper.INSTANCE.toResource(currencyExchangeTransactionModel);
        return ResponseEntity.ok(updateCurrencyExchangeTransactionResponse);
    }
}
