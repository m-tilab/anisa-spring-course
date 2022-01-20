package com.example.currencyexchangeservice.controller;

import com.example.currencyexchangeservice.domain.CurrencyExchange;
import com.example.currencyexchangeservice.service.ICurrencyExchangeService;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class CurrencyExchangeController {

    private final ICurrencyExchangeService currencyExchangeService;
    private final Environment environment;

    public CurrencyExchangeController(ICurrencyExchangeService currencyExchangeService, Environment environment) {
        this.currencyExchangeService = currencyExchangeService;
        this.environment = environment;
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

        Optional<CurrencyExchange> optionalCurrencyExchange = currencyExchangeService.getCurrencyExchange(from, to);

        if (optionalCurrencyExchange.isPresent()) {

            String serverPort = environment.getProperty("local.server.port");

            CurrencyExchange currencyExchange = optionalCurrencyExchange.get();

            currencyExchange.setEnvironment(serverPort);

            return currencyExchange;
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        //return new CurrencyExchange(100L, "USD", "IRR", new BigDecimal("270000"), "test");

    }
}
