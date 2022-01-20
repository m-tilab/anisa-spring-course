package com.example.currencyexchangeservice.service;

import com.example.currencyexchangeservice.domain.CurrencyExchange;

import java.util.Optional;

public interface ICurrencyExchangeService {
    Optional<CurrencyExchange> getCurrencyExchange(String from, String to);
}
