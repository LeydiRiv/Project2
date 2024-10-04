package com.example.check_in_check_out_system.repository;


import com.example.check_in_check_out_system.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}

