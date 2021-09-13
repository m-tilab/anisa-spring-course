package org.example.service;

public class RandomizerSessionScope {

    private int randomNumber = 5;

    public int getRandomNumber() {
        return randomNumber;
    }

    public int generateRandomNumber() {

        this.randomNumber = (int) (Math.random() * 100000);

        return this.randomNumber;
    }

}
