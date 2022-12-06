package com.example.demo.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * This is a copy of the AppointmentMaster entity in Domain Beans
 */
    @Entity
    @Table(name = "APPOINTMENT_MASTER")
    @GenericGenerator(name = "appointment_id_generator", strategy = "identity")
    public class AppointmentMaster implements java.io.Serializable, Cloneable, Comparable<AppointmentMaster> {

        private static final long serialVersionUID = 6711171273258426615L;
        private Long appointmentMasterId;
        private AppointmentMaster parent;
        private Set<AppointmentMaster> appointmentMasters = new HashSet<AppointmentMaster>();
        private Integer doctorId;
        private String doctorName;
        private Integer specialityId;
        private String specialtyName;
        private Integer officeId;
        private Long patientId;
        private String patientName;
        private Integer procedureId;
        private String procedureName;
        private Date apptDate;
        private Date startTime;
        private Date endTime;
        private Date endDate;
        private Integer frequency;
        private String createdBy;
        private Date createdDate;
        private String updatedBy;
        private Date updatedDate;
        private Integer status;
        private String apptType;
        private String apptName;
        private Boolean transport;
        private String comments;
        private String callUser;
        private Date callDate;
        private Date callTime;
        private Integer callStatus;

        private String transCallUser;
        private Date transCallDate;
        private Date transCallTime;
        private Integer transCallStatus;
        private Date transPickUpTime;

        private String visitCallUser;
        private Date visitCallDate;
        private Date visitCallTime;
        private Integer visitCallStatus;

        private Boolean deleteIndicator;
        private String cancellationReason;

        private String eligibUpdatedBy;
        private Date eligibUpdatedDate;
        private Date eligibUpdatedTime;
        private Integer eligibStatus;
        private Boolean ownRide;
        private Boolean mute;
        private Byte hedisVerify;
        private String callMgmtComments;

        public AppointmentMaster() {

        }

        /**
         * Adds a bi-directional link of type AppointmentMaster to the appointmentMasters set.
         *
         * @param appointmentMaster item to add
         */
        public void addAppointmentMaster(AppointmentMaster appointmentMaster) {
            appointmentMaster.setParent(this);
            this.appointmentMasters.add(appointmentMaster);
        }

        @Override
        public AppointmentMaster clone() throws CloneNotSupportedException {

            final AppointmentMaster copy = (AppointmentMaster) super.clone();

            copy.setApptDate(this.getApptDate());
            copy.setApptName(this.getApptName());
            copy.setApptType(this.getApptType());
            copy.setComments(this.getComments());
            copy.setCreatedBy(this.getCreatedBy());
            copy.setCreatedDate(this.getCreatedDate());
            copy.setDoctorId(this.getDoctorId());
            copy.setEndTime(this.getEndTime());
            copy.setAppointmentMasterId(this.getAppointmentMasterId());
            copy.setOfficeId(this.getOfficeId());
            copy.setPatientId(this.getPatientId());
            // end date doesn't matter as all the cloned appointments are for that
            // day only
            // copy.setEndDate(this.getEndDate());
            copy.setFrequency(this.getFrequency());
            copy.setSpecialityId(this.getSpecialityId());
            copy.setStartTime(this.getStartTime());
            copy.setStatus(this.getStatus());
            copy.setTransport(this.getTransport());
            copy.setUpdatedBy(this.getUpdatedBy());
            copy.setUpdatedDate(this.getUpdatedDate());
            return copy;
        }

        @Override
        public int compareTo(AppointmentMaster appointment) {
            long m = apptDate.getTime();
            long n = appointment.getApptDate().getTime();
            if (m > n) {
                return 1;
            } else if (m == n) {
                long i = startTime.getTime();
                long j = appointment.getStartTime().getTime();
                if (i > j) {
                    return 1;
                } else if (i == j) {
                    // return appointment with largest duration first. This is for
                    // implementing search over booked
                    long p = endTime.getTime() - startTime.getTime();
                    long q = appointment.endTime.getTime() - appointment.startTime.getTime();
                    return p <= q ? (int) (p != q ? 1 : 0) : -1;
                } else {
                    return -1;
                }

            } else {
                return -1;
            }
        }

        @Id
        @GeneratedValue(generator = "appointment_id_generator")
        @Column(name = "APPOINTMENT_MASTER_ID", unique = true, nullable = false)
        public Long getAppointmentMasterId() {
            return this.appointmentMasterId;
        }

        /**
         * Return the value associated with the column: appointmentMaster.
         *
         * @return A Set&lt;AppointmentMaster&gt; object (this.appointmentMaster)
         */
        @OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST,
                CascadeType.MERGE }, mappedBy = "parent")
        @Where(clause = "DELETE_INDICATOR is null or DELETE_INDICATOR=0")
        @org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
        @Column(name = "appointment_master_id", nullable = false)
        public Set<AppointmentMaster> getAppointmentMasters() {
            return this.appointmentMasters;

        }

        @Temporal(TemporalType.DATE)
        @Column(name = "APPT_DATE", length = 10)
        public Date getApptDate() {
            return this.apptDate;
        }

        @Column(name = "APPT_NAME", length = 45)
        public String getApptName() {
            return this.apptName;
        }

        @Column(name = "APPT_TYPE", length = 45)
        public String getApptType() {
            return this.apptType;
        }

        @Column(name = "CALL_DATE")
        public Date getCallDate() {
            return callDate;
        }

        @Column(name = "CALL_MGMT_COMMENTS")
        public String getCallMgmtComments() {
            return callMgmtComments;
        }

        @Column(name = "CALL_STATUS")
        public Integer getCallStatus() {
            return callStatus;
        }

        @Column(name = "CALL_TIME")
        public Date getCallTime() {
            return callTime;
        }

        @Column(name = "CALL_USER")
        public String getCallUser() {
            return callUser;
        }

        @Column(name = "CANCELLATION_REASON")
        public String getCancellationReason() {
            return cancellationReason;
        }

        @Column(name = "COMMENTS", length = 250)
        public String getComments() {
            return this.comments;
        }

        @Column(name = "CREATED_BY", length = 45)
        public String getCreatedBy() {
            return this.createdBy;
        }

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "CREATED_DATE", length = 19)
        public Date getCreatedDate() {
            return this.createdDate;
        }

        @Column(name = "DELETE_INDICATOR")
        public Boolean getDeleteIndicator() {
            return deleteIndicator;
        }

        @Column(name = "DOCTOR_ID", nullable = false)
        public Integer getDoctorId() {
            return this.doctorId;
        }

        @Column(name = "DOCTOR_NAME", length = 45)
        public String getDoctorName() {
            return doctorName;
        }

        @Column(name = "ELIGIB_STATUS")
        public Integer getEligibStatus() {
            return eligibStatus;
        }

        @Column(name = "ELIGIB_UPDATED_BY")
        public String getEligibUpdatedBy() {
            return eligibUpdatedBy;
        }

        @Column(name = "ELIGIB_UPDATED_DATE")
        public Date getEligibUpdatedDate() {
            return eligibUpdatedDate;
        }

        @Column(name = "ELIGIB_UPDATED_TIME")
        public Date getEligibUpdatedTime() {
            return eligibUpdatedTime;
        }

        @Temporal(TemporalType.DATE)
        @Column(name = "END_DATE", length = 10)
        public Date getEndDate() {
            return endDate;
        }

        @Temporal(TemporalType.TIME)
        @Column(name = "END_TIME", length = 8)
        public Date getEndTime() {
            return this.endTime;
        }

        @Column(name = "FREQUENCY")
        public Integer getFrequency() {
            return frequency;
        }

        @Column(name = "HEDIS_VERIFY")
        public Byte getHedisVerify() {
            return hedisVerify;
        }

        @Column(name = "MUTE")
        public Boolean getMute() {
            return mute;
        }

        @Column(name = "OFFICE_ID", nullable = true)
        public Integer getOfficeId() {
            return this.officeId;
        }

        @Column(name = "OWN_RIDE")
        public Boolean getOwnRide() {
            return ownRide;
        }

        /**
         * Return the value associated with the column: parent.
         *
         * @return A AppointmentMaster object (this.parent)
         */
        @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
        @org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
        @JoinColumn(name = "PARENT_ID", nullable = true)
        public AppointmentMaster getParent() {
            return this.parent;

        }

        @Column(name = "PATIENT_ID")
        public Long getPatientId() {
            return this.patientId;
        }

        @Column(name = "PATIENT_NAME", length = 45)
        public String getPatientName() {
            return patientName;
        }

        @Column(name = "PROCEDURE_ID")
        public Integer getProcedureId() {
            return procedureId;
        }

        @Column(name = "PROCEDURE_NAME", length = 45)
        public String getProcedureName() {
            return procedureName;
        }

        @Column(name = "SPECIALITY_ID")
        public Integer getSpecialityId() {
            return this.specialityId;
        }

        @Column(name = "SPECIALTY_NAME", length = 45)
        public String getSpecialtyName() {
            return specialtyName;
        }

        @Temporal(TemporalType.TIME)
        @Column(name = "START_TIME", length = 8)
        public Date getStartTime() {
            return this.startTime;
        }

        @Column(name = "STATUS")
        public Integer getStatus() {
            return this.status;
        }

        @Column(name = "TRANS_CALL_DATE")
        public Date getTransCallDate() {
            return transCallDate;
        }

        @Column(name = "TRANS_CALL_STATUS")
        public Integer getTransCallStatus() {
            return transCallStatus;
        }

        @Column(name = "TRANS_CALL_TIME")
        public Date getTransCallTime() {
            return transCallTime;
        }

        @Column(name = "TRANS_CALL_USER")
        public String getTransCallUser() {
            return transCallUser;
        }

        @Column(name = "TRANS_PICK_UP_TIME")
        public Date getTransPickUpTime() {
            return transPickUpTime;
        }

        @Column(name = "TRANSPORT")
        public Boolean getTransport() {
            return this.transport;
        }

        @Column(name = "UPDATED_BY", length = 45)
        public String getUpdatedBy() {
            return this.updatedBy;
        }

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "UPDATED_DATE", length = 19)
        public Date getUpdatedDate() {
            return this.updatedDate;
        }

        @Column(name = "VISIT_CALL_DATE")
        public Date getVisitCallDate() {
            return visitCallDate;
        }

        @Column(name = "VISIT_CALL_STATUS")
        public Integer getVisitCallStatus() {
            return visitCallStatus;
        }

        @Column(name = "VISIT_CALL_TIME")
        public Date getVisitCallTime() {
            return visitCallTime;
        }

        @Column(name = "VISIT_CALL_USER")
        public String getVisitCallUser() {
            return visitCallUser;
        }

        public void setAppointmentMasterId(Long appointmentMasterId) {
            this.appointmentMasterId = appointmentMasterId;
        }

        /**
         * Set the value related to the column: appointmentMaster.
         *
         * @param appointmentMaster the appointmentMaster value you wish to set
         */
        public void setAppointmentMasters(final Set<AppointmentMaster> appointmentMaster) {
            this.appointmentMasters = appointmentMaster;
        }

        public void setApptDate(Date apptDate) {
            this.apptDate = apptDate;
        }

        public void setApptName(String apptName) {
            this.apptName = apptName;
        }

        public void setApptType(String apptType) {
            this.apptType = apptType;
        }

        public void setCallDate(Date callDate) {
            this.callDate = callDate;
        }

        public void setCallMgmtComments(String callMgmtComments) {
            this.callMgmtComments = callMgmtComments;
        }

        public void setCallStatus(Integer callStatus) {
            this.callStatus = callStatus;
        }

        public void setCallTime(Date callTime) {
            this.callTime = callTime;
        }

        public void setCallUser(String callUser) {
            this.callUser = callUser;
        }

        public void setCancellationReason(String cancellationReason) {
            this.cancellationReason = cancellationReason;
        }

        public void setComments(String comments) {
            this.comments = comments;
        }

        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }

        public void setCreatedDate(Date createdDate) {
            this.createdDate = createdDate;
        }

        public void setDeleteIndicator(Boolean deleteIndicator) {
            this.deleteIndicator = deleteIndicator;
        }

        public void setDoctorId(Integer doctorId) {
            this.doctorId = doctorId;
        }

        public void setDoctorName(String doctorName) {
            this.doctorName = doctorName;
        }

        public void setEligibStatus(Integer eligibStatus) {
            this.eligibStatus = eligibStatus;
        }

        public void setEligibUpdatedBy(String eligibUpdatedBy) {
            this.eligibUpdatedBy = eligibUpdatedBy;
        }

        public void setEligibUpdatedDate(Date eligibUpdatedDate) {
            this.eligibUpdatedDate = eligibUpdatedDate;
        }

        public void setEligibUpdatedTime(Date eligibUpdatedTime) {
            this.eligibUpdatedTime = eligibUpdatedTime;
        }

        public void setEndDate(Date endDate) {
            this.endDate = endDate;
        }

        public void setEndTime(Date endTime) {
            this.endTime = endTime;
        }

        public void setFrequency(Integer frequency) {
            this.frequency = frequency;
        }

        public void setHedisVerify(Byte hedisVerify) {
            this.hedisVerify = hedisVerify;
        }

        public void setMute(Boolean mute) {
            this.mute = mute;
        }

        public void setOfficeId(Integer officeId) {
            this.officeId = officeId;
        }

        public void setOwnRide(Boolean ownRide) {
            this.ownRide = ownRide;
        }

        /**
         * Set the value related to the column: parent.
         *
         * @param parent the parent value you wish to set
         */
        public void setParent(final AppointmentMaster parent) {
            this.parent = parent;
        }

        public void setPatientId(Long patientId) {
            this.patientId = patientId;
        }

        public void setPatientName(String patientName) {
            this.patientName = patientName;
        }

        public void setProcedureId(Integer procedureId) {
            this.procedureId = procedureId;
        }

        public void setProcedureName(String procedureName) {
            this.procedureName = procedureName;
        }

        public void setSpecialityId(Integer specialityId) {
            this.specialityId = specialityId;
        }

        public void setSpecialtyName(String specialtyName) {
            this.specialtyName = specialtyName;
        }

        public void setStartTime(Date startTime) {
            this.startTime = startTime;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public void setTransCallDate(Date transCallDate) {
            this.transCallDate = transCallDate;
        }

        public void setTransCallStatus(Integer transCallStatus) {
            this.transCallStatus = transCallStatus;
        }

        public void setTransCallTime(Date transCallTime) {
            this.transCallTime = transCallTime;
        }

        public void setTransCallUser(String transCallUser) {
            this.transCallUser = transCallUser;
        }

        public void setTransPickUpTime(Date transPickUpTime) {
            this.transPickUpTime = transPickUpTime;
        }

        public void setTransport(Boolean transport) {
            this.transport = transport;
        }

        public void setUpdatedBy(String updatedBy) {
            this.updatedBy = updatedBy;
        }

        public void setUpdatedDate(Date updatedDate) {
            this.updatedDate = updatedDate;
        }

        public void setVisitCallDate(Date visitCallDate) {
            this.visitCallDate = visitCallDate;
        }

        public void setVisitCallStatus(Integer visitCallStatus) {
            this.visitCallStatus = visitCallStatus;
        }

        public void setVisitCallTime(Date visitCallTime) {
            this.visitCallTime = visitCallTime;
        }

        public void setVisitCallUser(String visitCallUser) {
            this.visitCallUser = visitCallUser;
        }


}
