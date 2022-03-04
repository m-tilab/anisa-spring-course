package com.example.springbootgraphql.domain.bank;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Client {

    UUID id;
    String firstname;
    String lastname;
    Client client;
}
