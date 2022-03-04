package com.example.springbootgraphql.resolver;

import com.example.springbootgraphql.domain.bank.BankAccount;
import com.example.springbootgraphql.domain.bank.Client;
import com.example.springbootgraphql.domain.bank.Currency;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class BankAccountResolver implements GraphQLQueryResolver {

    public BankAccount bankAccount(UUID id) {

        log.info("retrieving bank account with id: " + id);

        var clientA = Client.builder()
                .id(UUID.randomUUID())
                .firstname("Ali")
                .lastname("Ahmadi")
                .build();

        var clientB = Client.builder()
                .id(UUID.randomUUID())
                .firstname("Mehdi")
                .lastname("Mahdavi")
                .build();

        clientA.setClient(clientB);
        clientB.setClient(clientA);

        return BankAccount.builder()
                .id(id)
                .client(clientA)
                .currency(Currency.IRR)
                .build();
    }
}
