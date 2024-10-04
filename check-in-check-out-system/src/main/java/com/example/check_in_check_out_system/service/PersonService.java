package com.example.check_in_check_out_system.service;

import com.example.check_in_check_out_system.model.Person;
import com.example.check_in_check_out_system.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    //Check-in
    public Person checkIn(Person person) {
        person.setCheckInTime(LocalDateTime.now()); //Resolved ticket #1: now is not necesary input the date manually
        return personRepository.save(person);
    }

   //Check-out
    public Optional<Person> checkOut(Long id) {
        //Is mandatory do first the check-in if you want to record the check-out
        Person person = personRepository.findById(id).orElseThrow(() -> new RuntimeException("Non-existent" + "\nid: " + id)); //Validates if the id exists
        //Is the check-in done?
        if (person.getCheckInTime() == null) {
            throw new RuntimeException("ERROR! a registered check-in is required");
        }
        //Check-in register
        person.setCheckOutTime(LocalDateTime.now());
        return Optional.of(personRepository.save(person));
    }

    //All the records
    public List<Person> getRecords() {
        return personRepository.findAll();
    }

    //Delete a record
    public void deleteRecord(Long id) {
        personRepository.deleteById(id);
    }

}
