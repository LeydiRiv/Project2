package com.example.check_in_check_out_system.repository;

import com.example.check_in_check_out_system.model.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckinRepository extends JpaRepository<CheckIn, Long> {
}
