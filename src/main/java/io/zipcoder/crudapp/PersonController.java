package io.zipcoder.crudapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/people")
public class PersonController {
    @Autowired
    PersonRepository personRepo;

    @PostMapping(value = "/people")
    public ResponseEntity<Person> createPerson(@RequestBody Person p){
        return new ResponseEntity<>(personRepo.save(p), HttpStatus.CREATED);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable int id){
        return new ResponseEntity<>(personRepo.findOne(id), HttpStatus.FOUND);
    }
    @GetMapping(value = "/people")
    public ResponseEntity<List<Person>> getPersonList(){
        return new ResponseEntity<>((List<Person>)personRepo.findAll(), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable int id, @RequestBody Person p) {
        Person existingPerson = personRepo.findOne(id);

        p.setId(id);
        Person savedPerson = personRepo.save(p);
    
        if (existingPerson == null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPerson);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(savedPerson);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable int id){
        personRepo.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    }