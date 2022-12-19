package com.example.demo.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

//import javax.persistence.*;
import java.util.Date;

/**
 * VisitCheckin generated by hbm2java
 *
 * This is copied from domain-beans
 */
@Entity
@Table(name = "VISIT_CHECKIN")
@GenericGenerator(name = "VC_ID", strategy = "identity")
public class VisitCheckIn implements java.io.Serializable {

    private static final long serialVersionUID = -7109501901901366096L;

    private Long visitCheckinId;
    private Long appointmentId;
    private Date binTime;
    private Date consultationEndTime;
    private Date consultationStartTime;
    private Integer doctorId;
    private String atcDesc;
    private Integer insuranceId;
    private Integer medicalAssistant;
    private Integer officeId;
    private Long patientId;
    private Boolean patientLeft;

    private Integer providingMa;
    private Integer dischargeMa;
    private Date roomInTime;
    private Date roomOutTime;
    private Date swipeInTime;
    private Boolean transportationProvided;
    private Date visitDate;
    private Integer specialtyId;
    private Integer procedureId;
    private Boolean walkInLab;
    private Boolean walkInPcp;
    private Boolean walkInSpecialist;
    private String patientName;
    private Boolean firstVisit;
    private Date appointmentTime;
    private Integer roomNo;
    private Integer patientDailyNo;
    private Date maRoomInTime;
    private String insuranceCode;
    private String doctorCode;
    private String checkedInByUserId;
    private String checkedInByUserName;
    private String comments;
    private Integer deleted;
    private Date vitalsEndTime;
    private Boolean offsiteVisit;
    private Boolean adhocVisit;
    private Boolean pauseConsultation;
    private String patientFullName;

    // Transient fields
    private String doctorName;
    private String officeName;
    private String insuranceName;
    private String apptComments;
    private String officeNPI;
    private String practiceName;

    private Integer highRisk;
    private Date checkOutTime;
    private Integer eligibStatus;

    private String maCode;
    private String dischargeMaCode;
    private String providingMaCode;

    private Integer practiceId;
    private Integer drugHistoryViewed;

    public VisitCheckIn() {
        super();
    }

    public VisitCheckIn(Long patientId, Date visitDate, Integer insuranceId, Boolean transportationProvided,
                        Integer procedureId, Integer officeId, Integer doctorId, String atcDesc) {
        this.patientId = patientId;
        this.visitDate = visitDate;
        this.insuranceId = insuranceId;
        this.transportationProvided = transportationProvided;
        this.procedureId = procedureId;
        this.officeId = officeId;
        this.doctorId = doctorId;
        this.atcDesc = atcDesc;
    }

    @Column(name = "ADHOC_VISIT")
    public Boolean getAdhocVisit() {
        return adhocVisit;
    }

    /**
     * Return the value associated with the column: appointmentId.
     *
     * @return A Long object (this.appointmentId)
     */
    @Column(name = "appointment_id")
    public Long getAppointmentId() {
        return this.appointmentId;

    }

    @Column(name = "appointment_time")
    public Date getAppointmentTime() {
        return appointmentTime;
    }

    @Column(name = "APPT_COMMENTS")
    public String getApptComments() {
        return apptComments;
    }

    @Column(name = "DOC_SPECIALITY", length = 45)
    public String getAtcDesc() {
        return atcDesc;
    }

    /**
     * Return the value associated with the column: binTime.
     *
     * @return A Date object (this.binTime)
     */
    @Column(name = "bin_time")
    public Date getBinTime() {
        return this.binTime;

    }

    @Column(name = "checked_in_by_userid", length = 45)
    public String getCheckedInByUserId() {
        return checkedInByUserId;
    }

    @Column(name = "checked_in_by_username", length = 100)
    public String getCheckedInByUserName() {
        return checkedInByUserName;
    }

    @Column(name = "CHECK_OUT_TIME")
    public Date getCheckOutTime() {
        return checkOutTime;
    }

    @Column(name = "COMMENTS")
    public String getComments() {
        return comments;
    }

    /**
     * Return the value associated with the column: consultationEndTime.
     *
     * @return A Date object (this.consultationEndTime)
     */
    @Column(name = "consultation_end_time")
    public Date getConsultationEndTime() {
        return this.consultationEndTime;

    }

    /**
     * Return the value associated with the column: consultationStartTime.
     *
     * @return A Date object (this.consultationStartTime)
     */
    @Column(name = "consultation_start_time")
    public Date getConsultationStartTime() {
        return this.consultationStartTime;
    }

    @Column(name = "IS_DELETED")
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * Return the value associated with the column: dischargeMa.
     *
     * @return A String object (this.dischargeMa)
     */
    @Column(name = "discharge_ma")
    public Integer getDischargeMa() {
        return dischargeMa;
    }

    @Column(name = "DISCHARGE_MA_CODE")
    public String getDischargeMaCode() {
        return dischargeMaCode;
    }

    @Column(name = "doctor_code")
    public String getDoctorCode() {
        return doctorCode;
    }

    /**
     * Return the value associated with the column: doctorId.
     *
     * @return A Long object (this.doctorId)
     */
    @Column(name = "doctor_id")
    public Integer getDoctorId() {
        return this.doctorId;

    }

    @Transient
    public String getDoctorName() {
        return doctorName;
    }

    @Column(name = "DRUG_HISTORY_VIEWED")
    public Integer getDrugHistoryViewed() {
        return this.drugHistoryViewed;
    }

    @Column(name = "ELIGIB_STATUS")
    public Integer getEligibStatus() {
        return eligibStatus;
    }

    @Column(name = "first_visit")
    public Boolean getFirstVisit() {
        return firstVisit;
    }

    @Column(name = "HIGH_RISK")
    public Integer getHighRisk() {
        return highRisk;
    }

    @Column(name = "insurance_code")
    public String getInsuranceCode() {
        return insuranceCode;
    }

    /**
     * Return the value associated with the column: insuranceId.
     *
     * @return A Integer object (this.insuranceId)
     */
    @Column(name = "insurance_id")
    public Integer getInsuranceId() {
        return this.insuranceId;

    }

    @Transient
    public String getInsuranceName() {
        return insuranceName;
    }

    @Column(name = "MEDICAL_ASST_CODE")
    public String getMaCode() {
        return maCode;
    }

    @Column(name = "MA_ROOM_IN_TIME")
    public Date getMaRoomInTime() {
        return maRoomInTime;
    }

    /**
     * Return the value associated with the column: medicalAssistant.
     *
     * @return A String object (this.medicalAssistant)
     */
    @Column(name = "medical_assistant", length = 45)
    public Integer getMedicalAssistant() {
        return this.medicalAssistant;

    }

    @Column(name = "OFFICE_ID")
    public Integer getOfficeId() {
        return this.officeId;
    }

    @Transient
    public String getOfficeName() {
        return officeName;
    }

    @Transient
    public String getOfficeNPI() {
        return officeNPI;
    }

    @Column(name = "offsite_visit")
    public Boolean getOffsiteVisit() {
        return offsiteVisit;
    }

    @Column(name = "patient_daily_no")
    public Integer getPatientDailyNo() {
        return patientDailyNo;
    }

    @Column(name = "PAT_FULL_NAME")
    public String getPatientFullName() {
        return patientFullName;
    }

    @Column(name = "PATIENT_ID")
    public Long getPatientId() {
        return this.patientId;
    }

    /**
     * Return the value associated with the column: patientLeft.
     *
     * @return A Boolean object (this.patientLeft)
     */
    @Column(name = "patient_left")
    public Boolean getPatientLeft() {
        return this.patientLeft;

    }

    @Column(name = "patient_name", length = 45)
    public String getPatientName() {
        return patientName;
    }

    @Column(name = "PAUSE_CONSULT")
    public Boolean getPauseConsultation() {
        return pauseConsultation;
    }

    @Column(name = "PRACTICE_ID", length = 11)
    public Integer getPracticeId() {
        return practiceId;
    }

    @Transient
    public String getPracticeName() {
        return practiceName;
    }

    /**
     * Return the value associated with the column: visitDescription.
     *
     * @return A String object (this.visitDescription)
     */
    @Column(name = "procedure_id")
    public Integer getProcedureId() {
        return this.procedureId;

    }

    /**
     * Return the value associated with the column: providingMa.
     *
     * @return A String object (this.providingMa)
     */
    @Column(name = "providing_ma")
    public Integer getProvidingMa() {
        return this.providingMa;

    }

    @Column(name = "PROVIDING_MA_CODE")
    public String getProvidingMaCode() {
        return providingMaCode;
    }

    /**
     * Return the value associated with the column: roomInTime.
     *
     * @return A Date object (this.roomInTime)
     */
    @Column(name = "room_in_time")
    public Date getRoomInTime() {
        return this.roomInTime;

    }

    @Column(name = "room_no")
    public Integer getRoomNo() {
        return roomNo;
    }

    /**
     * Return the value associated with the column: roomOutTime.
     *
     * @return A Date object (this.roomOutTime)
     */
    @Column(name = "room_out_time")
    public Date getRoomOutTime() {
        return this.roomOutTime;

    }

    @Column(name = "specialty_id")
    public Integer getSpecialtyId() {
        return specialtyId;
    }

    /**
     * Return the value associated with the column: swipeInTime.
     *
     * @return A Date object (this.swipeInTime)
     */
    @Column(name = "swipe_in_time")
    public Date getSwipeInTime() {
        return this.swipeInTime;

    }

    @Column(name = "transportation_provided")
    public Boolean getTransportationProvided() {
        return this.transportationProvided;
    }

    @Id
    @GeneratedValue(generator = "VC_ID")
    @Column(name = "VISIT_CHECKIN_ID", unique = true, nullable = false)
    public Long getVisitCheckinId() {
        return this.visitCheckinId;
    }

    /**
     * Return the value associated with the column: visitDate.
     *
     * @return A Date object (this.visitDate)
     */
    @Column(name = "visit_date")
    public Date getVisitDate() {
        return this.visitDate;

    }

    @Column(name = "VITALS_END_TIME")
    public Date getVitalsEndTime() {
        return vitalsEndTime;
    }

    @Column(name = "walk_in_lab")
    public Boolean getWalkInLab() {
        return walkInLab;
    }

    @Column(name = "walk_in_pcp")
    public Boolean getWalkInPcp() {
        return walkInPcp;
    }

    @Column(name = "walk_in_specialist")
    public Boolean getWalkInSpecialist() {
        return walkInSpecialist;
    }

    public void setAdhocVisit(Boolean adhocVisit) {
        this.adhocVisit = adhocVisit;
    }

    /**
     * Set the value related to the column: appointmentId.
     *
     * @param appointmentId the appointmentId value you wish to set
     */
    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public void setApptComments(String apptComments) {
        this.apptComments = apptComments;
    }

    public void setAtcDesc(String atcDesc) {
        this.atcDesc = atcDesc;
    }

    /**
     * Set the value related to the column: binTime.
     *
     * @param binTime the binTime value you wish to set
     */
    public void setBinTime(Date binTime) {
        this.binTime = binTime;
    }

    public void setCheckedInByUserId(String checkedInByUserId) {
        this.checkedInByUserId = checkedInByUserId;
    }

    public void setCheckedInByUserName(String checkedInByUserName) {
        this.checkedInByUserName = checkedInByUserName;
    }

    public void setCheckOutTime(Date checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Set the value related to the column: consultationEndTime.
     *
     * @param consultationEndTime the consultationEndTime value you wish to set
     */
    public void setConsultationEndTime(Date consultationEndTime) {
        this.consultationEndTime = consultationEndTime;
    }

    /**
     * Set the value related to the column: consultationStartTime.
     *
     * @param consultationStartTime the consultationStartTime value you wish to set
     */
    public void setConsultationStartTime(Date consultationStartTime) {
        this.consultationStartTime = consultationStartTime;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    /**
     * Set the value related to the column: dischargeMa.
     *
     * @param dischargeMa value you wish to set
     */
    public void setDischargeMa(Integer dischargeMa) {
        this.dischargeMa = dischargeMa;
    }

    public void setDischargeMaCode(String dischargeMaCode) {
        this.dischargeMaCode = dischargeMaCode;
    }

    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode;
    }

    /**
     * Set the value related to the column: doctorId.
     *
     * @param doctorId the doctorId value you wish to set
     */
    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setDrugHistoryViewed(Integer drugHistoryViewed) {
        this.drugHistoryViewed = drugHistoryViewed;
    }

    public void setEligibStatus(Integer eligibStatus) {
        this.eligibStatus = eligibStatus;
    }

    public void setFirstVisit(Boolean firstVisit) {
        this.firstVisit = firstVisit;
    }

    public void setHighRisk(Integer highRisk) {
        this.highRisk = highRisk;
    }

    public void setInsuranceCode(String insuranceCode) {
        this.insuranceCode = insuranceCode;
    }

    /**
     * Set the value related to the column: insuranceId.
     *
     * @param insuranceId the insuranceId value you wish to set
     */
    public void setInsuranceId(Integer insuranceId) {
        this.insuranceId = insuranceId;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public void setMaCode(String maCode) {
        this.maCode = maCode;
    }

    public void setMaRoomInTime(Date maRoomInTime) {
        this.maRoomInTime = maRoomInTime;
    }

    /**
     * Set the value related to the column: medicalAssistant.
     *
     * @param medicalAssistant the medicalAssistant value you wish to set
     */
    public void setMedicalAssistant(Integer medicalAssistant) {
        this.medicalAssistant = medicalAssistant;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public void setOfficeNPI(String officeNPI) {
        this.officeNPI = officeNPI;
    }

    public void setOffsiteVisit(Boolean offsiteVisit) {
        this.offsiteVisit = offsiteVisit;
    }

    public void setPatientDailyNo(Integer patientDailyNo) {
        this.patientDailyNo = patientDailyNo;
    }

    public void setPatientFullName(String patientFullName) {
        this.patientFullName = patientFullName;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    /**
     * Set the value related to the column: patientLeft.
     *
     * @param patientLeft the patientLeft value you wish to set
     */
    public void setPatientLeft(Boolean patientLeft) {
        this.patientLeft = patientLeft;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setPauseConsultation(Boolean pauseConsultation) {
        this.pauseConsultation = pauseConsultation;
    }

    public void setPracticeId(Integer practiceId) {
        this.practiceId = practiceId;
    }

    public void setPracticeName(String practiceName) {
        this.practiceName = practiceName;
    }

    /**
     * Set the value related to the column: visitDescription.
     *
     * @param procedureId the procedureId value you wish to set
     */
    public void setProcedureId(Integer procedureId) {
        this.procedureId = procedureId;
    }

    /**
     * Set the value related to the column: providingMa.
     *
     * @param providingMa the providingMa value you wish to set
     */
    public void setProvidingMa(Integer providingMa) {
        this.providingMa = providingMa;
    }

    public void setProvidingMaCode(String providingMaCode) {
        this.providingMaCode = providingMaCode;
    }

    /**
     * Set the value related to the column: roomInTime.
     *
     * @param roomInTime the roomInTime value you wish to set
     */
    public void setRoomInTime(Date roomInTime) {
        this.roomInTime = roomInTime;
    }

    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }

    /**
     * Set the value related to the column: roomOutTime.
     *
     * @param roomOutTime the roomOutTime value you wish to set
     */
    public void setRoomOutTime(Date roomOutTime) {
        this.roomOutTime = roomOutTime;
    }

    public void setSpecialtyId(Integer specialtyId) {
        this.specialtyId = specialtyId;
    }

    /**
     * Set the value related to the column: swipeInTime.
     *
     * @param swipeInTime the swipeInTime value you wish to set
     */
    public void setSwipeInTime(Date swipeInTime) {
        this.swipeInTime = swipeInTime;
    }

    public void setTransportationProvided(Boolean transportationProvided) {
        this.transportationProvided = transportationProvided;
    }

    public void setVisitCheckinId(Long visitCheckinId) {
        this.visitCheckinId = visitCheckinId;
    }

    /**
     * Set the value related to the column: visitDate.
     *
     * @param visitDate the visitDate value you wish to set
     */
    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public void setVitalsEndTime(Date vitalsEndTime) {
        this.vitalsEndTime = vitalsEndTime;
    }

    public void setWalkInLab(Boolean walkInLab) {
        this.walkInLab = walkInLab;
    }

    public void setWalkInPcp(Boolean walkInPcp) {
        this.walkInPcp = walkInPcp;
    }

    public void setWalkInSpecialist(Boolean walkInSpecialist) {
        this.walkInSpecialist = walkInSpecialist;
    }

}