package io.zipcoder.crudapp;

import javax.persistence.Id;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer>{
    
}
