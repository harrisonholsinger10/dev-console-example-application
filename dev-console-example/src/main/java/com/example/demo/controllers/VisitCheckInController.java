package com.example.demo.controllers;

import com.example.demo.services.VisitCheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000/")
public class VisitCheckInController {

    @Autowired
    private VisitCheckInService service;

    @GetMapping("/visitCheckin")
    String getFirstAppointment() {
        service.insertVisitCheckinQuery();
        return service.successfulInsert();
    }

}
