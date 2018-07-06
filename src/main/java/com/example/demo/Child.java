package com.example.demo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@Entity
public class Child {

    @Id
    @GeneratedValue
    private Long id;

    private String otherValue;

    @OneToOne
    private Parent parent;
}
