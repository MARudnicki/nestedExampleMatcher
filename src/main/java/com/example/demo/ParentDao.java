package com.example.demo;

import org.springframework.data.domain.Example;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ParentDao extends CrudRepository<Parent, Long> {

    List<Parent> findAll(Example<Parent> example);

}
