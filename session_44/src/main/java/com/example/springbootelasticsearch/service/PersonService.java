package com.example.springbootelasticsearch.service;

import com.example.springbootelasticsearch.document.Person;
import com.example.springbootelasticsearch.helper.Indexes;
import com.example.springbootelasticsearch.repository.PersonRepository;
import com.example.springbootelasticsearch.search.SearchRequestDTO;
import com.example.springbootelasticsearch.search.SearchUtil;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.SearchHit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PersonService {

    private static final Logger LOG = LoggerFactory.getLogger(PersonService.class);
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private final PersonRepository repository;
    private final RestHighLevelClient client;

    public PersonService(PersonRepository repository, RestHighLevelClient client) {
        this.repository = repository;
        this.client = client;
    }

    public void save(final Person person) {

        repository.save(person);
    }

    public Person findById(String id) {

        return repository.findById(id).orElse(null);
    }

    public List<Person> search(SearchRequestDTO dto) {

        SearchRequest searchRequest = SearchUtil.buildSearchRequest(Indexes.PERSON_INDEX, dto);

        return searchInternal(searchRequest);


    }

    private List<Person> searchInternal(SearchRequest searchRequest) {

        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        if (searchRequest == null) {
            LOG.error("Failed to build search request");
            return Collections.emptyList();
        }

        try {
            final SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);

            final SearchHit[] searchHits = response.getHits().getHits();
            final List<Person> personList = new ArrayList<>(searchHits.length);
            for (SearchHit hit : searchHits) {
                personList.add(
                        MAPPER.readValue(hit.getSourceAsString(), Person.class)
                );
            }

            return personList;
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return Collections.emptyList();
        }

    }
}
