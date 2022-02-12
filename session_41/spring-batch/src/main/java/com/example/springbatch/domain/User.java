package com.example.springbatch.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.ZonedDateTime;

@Entity
@Data
public class User {

    @Id
    private Long id;
    private String name;
    private String dept;
    private Integer salary;
    private ZonedDateTime dateTime;
}
