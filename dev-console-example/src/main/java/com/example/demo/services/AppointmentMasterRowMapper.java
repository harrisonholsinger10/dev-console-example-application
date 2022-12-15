package com.example.demo.services;

import com.example.demo.entities.AppointmentMaster;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppointmentMasterRowMapper implements RowMapper<AppointmentMaster> {

    @Override
    public AppointmentMaster mapRow(ResultSet rs, int rowNum) throws SQLException{
        AppointmentMaster appointmentMaster = new AppointmentMaster();
        appointmentMaster.setAppointmentMasterId(rs.getLong("APPOINTMENT_MASTER_ID"));
        appointmentMaster.setPatientName(rs.getString("PATIENT_NAME"));
        appointmentMaster.setApptDate(rs.getDate("APPT_DATE"));
        appointmentMaster.setStartTime(rs.getTime("START_TIME"));

        return appointmentMaster;

    }
}
