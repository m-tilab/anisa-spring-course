package org.example.bean;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ConsumerProduct implements GenericProduct{
    @Override
    public int getQualifiedPrice() {

        return new Random().nextInt(price);
    }
}
