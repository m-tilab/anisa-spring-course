package com.example.currencyexchangeservice.service;

import com.example.currencyexchangeservice.domain.CurrencyExchange;
import com.example.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurrencyExchangeService implements ICurrencyExchangeService {

    private final CurrencyExchangeRepository currencyExchangeRepository;

    public CurrencyExchangeService(CurrencyExchangeRepository currencyExchangeRepository) {
        this.currencyExchangeRepository = currencyExchangeRepository;
    }

    @Override
    public Optional<CurrencyExchange> getCurrencyExchange(String from, String to) {

        return currencyExchangeRepository.findByFromAndTo(from, to);

    }
}
