package com.example.mongorecipeapp.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
public class Notes {

    @Id
    private String id;
    private String recipeNotes;

}
