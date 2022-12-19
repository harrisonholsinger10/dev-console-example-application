package com.example.demo.repositories;

import com.example.demo.entities.VisitCheckinEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitCheckinRepository extends JpaRepository<VisitCheckinEntities, Long> {


}
