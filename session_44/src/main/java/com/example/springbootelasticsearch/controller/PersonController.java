package com.example.springbootelasticsearch.controller;

import com.example.springbootelasticsearch.document.Person;
import com.example.springbootelasticsearch.search.SearchRequestDTO;
import com.example.springbootelasticsearch.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping
    public void save(@RequestBody Person person) {

        service.save(person);
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable String id) {

        return service.findById(id);
    }

    @PostMapping("/search")
    public List<Person> search(@RequestBody final SearchRequestDTO dto) {
        return service.search(dto);
    }
}
