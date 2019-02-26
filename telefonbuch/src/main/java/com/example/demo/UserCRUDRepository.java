package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface UserCRUDRepository extends CrudRepository<User, String> {}
