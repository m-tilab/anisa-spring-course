package org.example.bean;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class IndustrialProduct extends GenericProduct{
    @Override
    public int getQualifiedPrice() {

        return new Random().nextInt(price);
    }
}
