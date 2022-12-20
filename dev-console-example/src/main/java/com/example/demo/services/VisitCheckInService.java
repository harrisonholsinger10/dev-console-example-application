package com.example.demo.services;


import com.example.demo.repositories.VisitCheckInRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitCheckInService {

    @Autowired
    private VisitCheckInRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertVisitCheckinQuery() {
        entityManager.createNativeQuery("INSERT INTO `DASHBOARD_PROD`.`VISIT_CHECKIN` (`VISIT_CHECKIN_ID`, `PATIENT_ID`, `OFFICE_ID`, `DOCTOR_ID`, `DOCTOR_CODE`, `DOC_SPECIALITY`, `MEDICAL_ASSISTANT`, `INSURANCE_ID`, `INSURANCE_CODE`, `PATIENT_NAME`, `PATIENT_DAILY_NO`, `APPOINTMENT_ID`, `APPOINTMENT_TIME`, `VISIT_DATE`, `PROCEDURE_ID`, `WALK_IN_PCP`, `WALK_IN_LAB`, `WALK_IN_SPECIALIST`, `TRANSPORTATION_PROVIDED`, `SWIPE_IN_TIME`, `BIN_TIME`, `ROOM_NO`, `ROOM_IN_TIME`, `MA_ROOM_IN_TIME`, `ROOM_OUT_TIME`, `CONSULTATION_START_TIME`, `CONSULTATION_END_TIME`, `PATIENT_LEFT`, `PROVIDING_MA`, `FIRST_VISIT`, `CHECKED_IN_BY_USERID`, `CHECKED_IN_BY_USERNAME`, `IS_DELETED`, `COMMENTS`, `DISCHARGE_MA`, `VITALS_END_TIME`, `APPT_COMMENTS`, `OFFSITE_VISIT`, `HIGH_RISK`, `CHECK_OUT_TIME`, `PAT_BALANCE`, `PAT_BALANCE_SOURCE`, `AMT_COLLECTED`, `AMT_COLLECTED_SOURCE`, `ADHOC_VISIT`, `PAUSE_CONSULT`, `ELIGIB_STATUS`, `MEDICAL_ASST_CODE`, `PROVIDING_MA_CODE`, `DISCHARGE_MA_CODE`, `PAT_FULL_NAME`, `SPECIALTY_ID`, `LEGACY_CHECKIN_ID`, `PRACTICE_ID`, `DRUG_HISTORY_VIEWED`, `PAUSE_CONSULT_START_TIME`, `PAUSE_CONSULT_END_TIME`) \n" +
                        "VALUES (NULL, 1105102, 10329, 127551, 'CodeSoapUI', 'PCP', NULL, 1110, 'HG', 'PatientPortal', NULL, 17927379, '10:40:00', '2022-11-14', 18215, 0, 0, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, 5520, 'SoapUI', 0, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, 'PatientPortal Test1', 3631, NULL, NULL, NULL, NULL, NULL);\n")
                .executeUpdate();
    }

    public String successfulInsert() {
        String note = "Insert Was Successful!";
        return note;
    }
}
