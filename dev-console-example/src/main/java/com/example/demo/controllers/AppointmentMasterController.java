package com.example.demo.controllers;

import com.example.demo.entities.AppointmentMaster;
import com.example.demo.services.AppointmentMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000/")
public class AppointmentMasterController {

    @Autowired
    private AppointmentMasterService service;

    @GetMapping("/appointment")
    Optional<AppointmentMaster> getFirstAppointment() {
        return service.findAppointmentOne();
    }

    @GetMapping("/insertAppointment")
    List<AppointmentMaster> insertTestAppointment(){
        service.deleteQuery();
        service.insertWithQuery();
        return service.resultOfInsertQuery();
    }

}
