package com.example.mongorecipeapp.repositories;

import com.example.mongorecipeapp.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by jt on 6/13/17.
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, String> {

    Optional<UnitOfMeasure> findByDescription(String description);
}