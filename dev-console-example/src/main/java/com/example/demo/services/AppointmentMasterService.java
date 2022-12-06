package com.example.demo.services;

import com.example.demo.entities.AppointmentMaster;
import com.example.demo.repositories.AppointmentMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentMasterService {

    @Autowired
    private AppointmentMasterRepository repository;

    public Optional<AppointmentMaster> findAppointmentOne(){
        return repository.findById(1L);
    }

}
