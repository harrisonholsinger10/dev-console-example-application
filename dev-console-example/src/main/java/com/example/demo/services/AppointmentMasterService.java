package com.example.demo.services;

import com.example.demo.entities.AppointmentMaster;
import com.example.demo.repositories.AppointmentMasterRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentMasterService {

    @Autowired
    private AppointmentMasterRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<AppointmentMaster> findAppointmentOne(){
        return repository.findById(1L);
    }


    @Transactional
    public void insertWithQuery(){
        entityManager.createNativeQuery("INSERT INTO DASHBOARD_PROD.APPOINTMENT_MASTER (SourceApptType,SourceApptId,APPOINTMENT_MASTER_ID,PARENT_ID,PATIENT_ID,PATIENT_NAME,DOCTOR_ID,DOCTOR_NAME,OFFICE_ID,SPECIALITY_ID,SPECIALTY_NAME,PROCEDURE_ID,PROCEDURE_NAME,APPT_DATE,END_DATE,START_TIME,END_TIME,FREQUENCY,STATUS,APPT_TYPE,APPT_NAME,CREATED_BY,CREATED_DATE,UPDATED_BY,UPDATED_DATE,TRANSPORT,TRANSPORT_COMMENT,COMMENTS,CALL_DATE,CALL_TIME,CALL_USER,CALL_STATUS,TRANS_CALL_DATE,TRANS_CALL_TIME,TRANS_CALL_USER,TRANS_PICK_UP_TIME,TRANS_CALL_STATUS,VISIT_CALL_DATE,VISIT_CALL_TIME,VISIT_CALL_USER,VISIT_CALL_STATUS,DELETE_INDICATOR,CANCELLATION_REASON,ELIGIB_UPDATED_BY,ELIGIB_UPDATED_DATE,ELIGIB_UPDATED_TIME,ELIGIB_STATUS,OWN_RIDE,MUTE,HEDIS_VERIFY,CALL_MGMT_COMMENTS,PRACTICE_ID,APPLICATION_CODE) VALUES (NULL,NULL,NULL,NULL,1105102,'PatientPortal, Test1',127551,'Chamblain, Melissa',10329,2769,'PCP',18215,'TH - Video - OV',CURRENT_DATE,NULL,CURRENT_TIME,'10:20:00',NULL,'1','N','PatientPortal, Test1','SVC-ENT-JWTK-NONPROD','2022-10-20 09:59:50',NULL,NULL,0,NULL,'Medication consult',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,'ECCP');\n")
                .executeUpdate();
    }

    /*@Transactional
    public Optional resultOfQuery(){

    Optional result = entityManager.createNativeQuery("SELECT * FROM APPOINTMENT_MASTER WHERE PATIENT_ID = 1105102 AND PROCEDURE_ID = 18215")
                .getResultList()
            .stream().findFirst();
    return result;
    }*/

    public List<AppointmentMaster> resultOfInsertQuery(){
        String sql = "SELECT * FROM DASHBOARD_PROD.APPOINTMENT_MASTER WHERE PATIENT_ID = 1105102 AND PROCEDURE_ID = 18215 LIMIT 1";

        List<AppointmentMaster> appointmentMasters = jdbcTemplate.query(sql, new AppointmentMasterRowMapper());
        return appointmentMasters;
    }

    public void deleteQuery(){
        String sql = "DELETE FROM DASHBOARD_PROD.APPOINTMENT_MASTER WHERE PATIENT_ID = 1105102 AND PROCEDURE_ID = 18215;";
        jdbcTemplate.update(sql);
    }

}
