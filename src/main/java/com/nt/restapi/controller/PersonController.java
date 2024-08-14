package com.nt.restapi.controller;

import com.nt.restapi.model.Person;
import com.nt.restapi.service.PersonServiceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PersonController {

	@Autowired
	PersonServiceImp personServiceImp;

	@PostMapping("/register")
	public ResponseEntity<String> saveRecord(@RequestBody Person person) {
		System.out.println("PersonController.saveRecord()");
		String message = personServiceImp.registerPerson(person);
		return new ResponseEntity<String>(message, HttpStatus.CREATED);
	}

	@PostMapping("/all")
	public ResponseEntity<List<Person>> list() {

		System.out.println("PersonController.list()");
		return new ResponseEntity<List<Person>>(personServiceImp.showAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Person> getRecordById(@PathVariable Integer id) {
		System.out.println("PersonController.getRecordById()" + id);
		return new ResponseEntity<Person>(personServiceImp.getPersonById(id), HttpStatus.OK);
	}

	@PutMapping("/updatePerson")
	public ResponseEntity<String> updatePerson(@RequestBody Person person) {

		System.out.println("PersonController.updatePerson()");
		String message = personServiceImp.registerPerson(person);
		return new ResponseEntity<String>(message, HttpStatus.CREATED);
	}

	@PatchMapping("/updatePersonAge/{id}/{age}")
	public ResponseEntity<String> updatePersonAge(@PathVariable Integer id, @PathVariable String age) {

		System.out.println("PersonController.updatePersonAge() " + id + " age " + age);
		String message = personServiceImp.updateAge(id, age);

		return new ResponseEntity<String>(message, HttpStatus.CREATED);
	}

	@GetMapping("/delete/{id}")
	public ResponseEntity<String> deletePerson(@PathVariable Integer id) {

		System.out.println("PersonController.deletePerson()");
		personServiceImp.deletePerson(id);

		return new ResponseEntity<String>("deleted " + id, HttpStatus.OK);

	}

}
