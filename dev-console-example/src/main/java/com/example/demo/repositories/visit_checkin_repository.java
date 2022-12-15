package com.example.demo.repositories;

import com.example.demo.entities.AppointmentMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface visit_checkin_repository extends JpaRepository<AppointmentMaster, Long> {


}
