package com.example.demo.repositories;

import com.example.demo.config.DashboardJPAConfig;
import com.example.demo.entities.AppointmentMaster;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentMasterRepository extends JpaRepository<AppointmentMaster, Long> {


}
