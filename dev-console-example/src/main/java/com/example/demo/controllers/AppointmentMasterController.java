package com.example.demo.controllers;

import com.example.demo.entities.AppointmentMaster;
import com.example.demo.services.AppointmentMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
public class AppointmentMasterController {

    @Autowired
    private AppointmentMasterService service;

    @GetMapping("/appointment")
    Optional<AppointmentMaster> getFirstAppointment() {
        return service.findAppointmentOne();
    }

    @GetMapping("/insertAppointment")
    Collection insertTestAppointment(){
        service.insertWithQuery();
        return service.resultOfQuery();
    }

}
