package com.example.springbootelasticsearch.repository;

import com.example.springbootelasticsearch.document.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends ElasticsearchRepository<Person, String> {
}
