package io.zipcoder.crudapp;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @RequestMapping(value = "/people", method = RequestMethod.POST)
    @ResponseBody
    public Person createPerson(Person p){
        return new Person();
    }
    @RequestMapping(value = "/people/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Person getPerson(int id){
        return null;
    }
    @RequestMapping(value = "/people", method = RequestMethod.GET)
    @ResponseBody
    public List<Person> getPersonList(){
        return null;
    }
    @RequestMapping(value = "/people/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Person updatePerson(Person p){
        return null;
    }
    @RequestMapping(value = "/people/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deletePerson(int id){
    }
}
