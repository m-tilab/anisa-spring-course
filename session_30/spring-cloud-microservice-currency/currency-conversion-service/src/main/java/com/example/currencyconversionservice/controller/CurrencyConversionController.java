package com.example.currencyconversionservice.controller;

import com.example.currencyconversionservice.domain.CurrencyConversion;
import com.example.currencyconversionservice.service.CurrencyExchangeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    private final CurrencyExchangeProxy currencyExchangeProxy;

    public CurrencyConversionController(CurrencyExchangeProxy currencyExchangeProxy) {
        this.currencyExchangeProxy = currencyExchangeProxy;
    }

    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable String from, @PathVariable String to,
                                                               @PathVariable BigDecimal quantity) {

        CurrencyConversion currencyConversion = currencyExchangeProxy.retrieveExchangeValue(from, to);

        return new CurrencyConversion(currencyConversion.getId(), from, to, quantity, currencyConversion.getConversionMultiple()
                , quantity.multiply(currencyConversion.getConversionMultiple())
                , currencyConversion.getEnvironment() + " feign");


        //return new CurrencyConversion(1000L, from, to, quantity, BigDecimal.ZERO, BigDecimal.ZERO,"test");
    }

    @GetMapping("/currency-conversion-rest-template/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversionRestTemplate(@PathVariable String from, @PathVariable String to,
                                                                      @PathVariable BigDecimal quantity) {

        ResponseEntity<CurrencyConversion> currencyConversionResponseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                CurrencyConversion.class, Map.of("from", from, "to", to));

        CurrencyConversion currencyConversion = currencyConversionResponseEntity.getBody();

        return new CurrencyConversion(currencyConversion.getId(), from, to, quantity, currencyConversion.getConversionMultiple()
                , quantity.multiply(currencyConversion.getConversionMultiple())
                , currencyConversion.getEnvironment() + " rest template");


        //return new CurrencyConversion(1000L, from, to, quantity, BigDecimal.ZERO, BigDecimal.ZERO,"test");
    }
}
