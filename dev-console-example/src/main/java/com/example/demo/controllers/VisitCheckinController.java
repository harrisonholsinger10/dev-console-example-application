package com.example.demo.controllers;

import com.example.demo.entities.VisitCheckIn;
import com.example.demo.services.VisitCheckinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000/")
public class VisitCheckinController {

    @Autowired
    private VisitCheckinService service;

    @GetMapping("/visitCheckin")
    String getFirstAppointment() {
        service.insertVisitCheckinQuery();
        return service.successfulInsert();
    }

}
