package org.example.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WelcomeService implements GenericWelcomeService {

    public List<String> getWelcomeMessage(String fullname) {

        //jdk 1.2
        //List myWelcomeMessage = new ArrayList();
        // jdk 1.5
        //List<String> myWelcomeMessage = new ArrayList<String>();
        // jdk 1.7
        //List<String> myWelcomeMessage = new ArrayList<>();
        // jdk 10
        var myWelcomeMessage = new ArrayList<String>();

        myWelcomeMessage.add("Hello! ");
        myWelcomeMessage.add(fullname);
        myWelcomeMessage.add(", Welcome to Anisa Spring Course!");

        return myWelcomeMessage;
    }
}
