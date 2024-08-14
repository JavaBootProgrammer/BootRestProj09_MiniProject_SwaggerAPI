package com.nt.restapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nt.restapi.model.Person;

@Service
public interface PersonService {
    public String registerPerson(Person person);
    public List<Person> showAll();
    public Person getPersonById(Integer id);
    public String updatePerson(Person person);
    public String updateAge(Integer id, String age);
    public String deletePerson(Integer id);
}
