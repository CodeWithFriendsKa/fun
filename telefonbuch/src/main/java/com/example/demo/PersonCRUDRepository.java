package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface PersonCRUDRepository extends CrudRepository<Person, String> {}
