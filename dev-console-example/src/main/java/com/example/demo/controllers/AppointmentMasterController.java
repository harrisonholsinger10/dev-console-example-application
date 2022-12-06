package com.example.demo.controllers;

import com.example.demo.entities.AppointmentMaster;
import com.example.demo.repositories.AppointmentMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AppointmentMasterController {

    @Autowired
    private AppointmentMasterRepository repository;

    @GetMapping("/appointment")
    Optional<AppointmentMaster> getFirstAppointment() {
        return repository.findById(1l);
    }

}
