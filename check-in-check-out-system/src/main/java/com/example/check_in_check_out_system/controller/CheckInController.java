package com.example.check_in_check_out_system.controller;

import com.example.check_in_check_out_system.model.CheckIn;
import com.example.check_in_check_out_system.service.CheckInService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


//This can handle HTTP requests and return responses in JSON format
@RestController
@RequestMapping("/api/v1/checkins")
public class CheckInController {

    @Autowired
    private CheckInService checkInService;

    //Check-in
    @PostMapping("/{employeeId}")
    public ResponseEntity<CheckIn> checkIn(@PathVariable Long employeeId) {
        CheckIn checkIn = checkInService.checkIn(employeeId);
        return new ResponseEntity<>(checkIn, HttpStatus.CREATED);
    }

    //Check-out
    @PutMapping("/checkout/{checkInId}")
    public ResponseEntity<CheckIn> checkOut(@PathVariable Long checkInId) {
        CheckIn checkIn = checkInService.checkOut(checkInId);
        return ResponseEntity.ok(checkIn);
    }

    //Get
    @GetMapping
    public ResponseEntity<List<CheckIn>> getAllCheckIns() {
        List<CheckIn> checkIns = checkInService.getAllCheckIns();
        return ResponseEntity.ok(checkIns);
    }

    //Delete
    @DeleteMapping("/{checkInId}")
    public ResponseEntity<Void> deleteCheckIn(@PathVariable Long checkInId) {
        checkInService.deleteCheckIns(checkInId);
        return ResponseEntity.noContent().build();
    }

}