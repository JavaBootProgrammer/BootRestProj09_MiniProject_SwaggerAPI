package com.nt.restapi.service;

import com.nt.restapi.model.Person;
import com.nt.restapi.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonServiceImp implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public String registerPerson(Person person) {

        System.out.println("PersonServiceImp.registerPerson()");
        return personRepository.save(person).getId() + " created";
    }

    @Override
    public List<Person> showAll() {
        System.out.println("PersonServiceImp.showAll()");

        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(Integer id) {
        System.out.println("PersonServiceImp.getPersonById()");
        return personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("imvalid "));
    }

    @Override
    public String updatePerson(Person person) {
        System.out.println("PersonServiceImp.updatePerson()");

        Optional<Person> opt = personRepository.findById(person.getId());

        if (opt.isPresent()) {
            return personRepository.save(person).getId() + " updated";
        }
        return personRepository.save(person).getId() + "NOT updated";

    }

    @Override
    public String updateAge(Integer id, String age) {
        System.out.println("PersonServiceImp.updateAge()");
        Optional<Person> opt = personRepository.findById(id);
        System.out.println(" Person details : " + opt);

        System.out.println("new page" + age);
        System.out.println("old page" + opt.get().getAge());

        if (opt.isPresent()) {
            opt.get().setAge(age);

            personRepository.save(opt.get());

            System.out.println("PersonServiceImp.updateAge()" + opt.get().getAge() + " updated");
            return opt.get() + " updated";
        }
        return opt.get() + "NOT updated";

    }

    @Override
    public String deletePerson(Integer id) {
        System.out.println("PersonServiceImp.deletePerson()" + id);
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            personRepository.deleteById(id);

            System.out.print("person " + id + " has been deleted ");
            return id + " deleted";
        }
        return id + "not deleted";
    }

}
