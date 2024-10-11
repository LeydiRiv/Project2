package com.example.check_in_check_out_system.service;

import com.example.check_in_check_out_system.model.CheckIn;
import com.example.check_in_check_out_system.model.Employee;
import com.example.check_in_check_out_system.repository.CheckinRepository;
import com.example.check_in_check_out_system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CheckInService {


    private final CheckinRepository checkinRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public CheckInService(CheckinRepository checkinRepository, EmployeeRepository employeeRepository) {
        this.checkinRepository = checkinRepository;
        this.employeeRepository = employeeRepository;
    }

    //Check-in
    public CheckIn checkIn(Long employeeId) {
        //If the Employee exist
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Error! The Employee doesn't exist."));
        // Check if there is any active check-in
        for (CheckIn checkIn : employee.getCheckIns()) {
            if (checkIn.getStatus()) {
                throw new RuntimeException("Error! The employee already has an active check-in.");
            }
        }
        CheckIn checkIn = new CheckIn();
        checkIn.setCheckInTime(LocalDateTime.now());
        checkIn.setStatus(true);
        checkIn.setEmployee(employee);

        return checkinRepository.save(checkIn); //guardamos
    }

    //Check-out
    public CheckIn checkOut(Long checkInId) {
        // Check if there is any active check-in
        CheckIn checkIn = checkinRepository.findById(checkInId)
                .orElseThrow(() -> new RuntimeException("Error! Mandatory to first check in."));
        checkIn.setCheckOutTime(LocalDateTime.now());
        checkIn.setStatus(false);

        return checkinRepository.save(checkIn);
    }

    //Get all the check-in records
    public List<CheckIn> getAllCheckIns() {
        return checkinRepository.findAll();
    }

    //Delete a check-in by its ID
    public void deleteCheckIns(Long checkInId) {
        checkinRepository.deleteById(checkInId);
    }


}
