package com.example.demo.repositories;

import com.example.demo.entities.VisitCheckIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitCheckInRepository extends JpaRepository<VisitCheckIn, Long> {


}
