package com.example.check_in_check_out_system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Person {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private LocalDateTime checkInTime;
        private LocalDateTime checkOutTime;


        //Getter method for ID
        public Long getId(){
            return id;
        }

        // Setter method for ID
        public void setId(Long id){
            this.id=id;
        }

        //Getter method for Name
        public String getName(){
            return name;
        }

        // Setter method for Name
        public void setName(String name){
            this.name=name;
        }

        //Getter method for Check-in
        public LocalDateTime getCheckInTime(){
            return checkInTime;
        }

        // Setter method for Check-in
        public void setCheckInTime(LocalDateTime checkInTime){
            this.checkInTime=checkInTime;
        }

        //Getter method for Check-out
        public LocalDateTime getCheckOutTime(){
            return checkOutTime;
        }

        // Setter method for Check-out
        public void setCheckOutTime(LocalDateTime checkOutTime){
            this.checkOutTime=checkOutTime;
        }


    }
