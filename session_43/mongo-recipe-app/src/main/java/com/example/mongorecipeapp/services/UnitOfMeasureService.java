package com.example.mongorecipeapp.services;

import com.example.mongorecipeapp.commands.UnitOfMeasureCommand;

import java.util.Set;


public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();
}
