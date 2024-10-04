package com.example.check_in_check_out_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import com.example.check_in_check_out_system.model.Person;
import com.example.check_in_check_out_system.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//This can handle HTTP requests and return responses in JSON format
@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    @Autowired
    private PersonService personService;


    //URL: http://localhost:8080/api/v1/people/checkin
    @PostMapping("/checkin") //Create a new resource
    public ResponseEntity<Person> checkIn(@RequestBody Person person){//Json
        Person savedPerson = personService.checkIn(person);
        return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
    }


    //URL: http://localhost:8080/api/v1/people/checkout/{id}
    @PutMapping("/checkout/{id}") //Updates an existing resource
    public ResponseEntity<Optional<Person>> checkOut(@PathVariable Long id){
        Optional<Person> person = personService.checkOut(id);
        return  ResponseEntity.ok(person);
    }


    //URL: http://localhost:8080/api/v1/people
    @GetMapping //Retrieves data for a resource
    public ResponseEntity<Iterable<Person>> getRecords(){
        return ResponseEntity.ok(personService.getRecords());
    }


    //URL: http://localhost:8080/api/v1/people/{id}
    @DeleteMapping("/{id}") //Deletes a resource
    public ResponseEntity<Void> deleteRecord(@PathVariable Long id){
        personService.deleteRecord(id);
        return ResponseEntity.noContent().build();
    }

}
