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
        private Long patientId;
        private String patientName;
        private Date apptDate;
        private Date startTime;
        private Date endTime;


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
            copy.setEndTime(this.getEndTime());
            copy.setAppointmentMasterId(this.getAppointmentMasterId());
            copy.setPatientId(this.getPatientId());
            // end date doesn't matter as all the cloned appointments are for that
            // day only
            // copy.setEndDate(this.getEndDate());
            copy.setStartTime(this.getStartTime());
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


        @Temporal(TemporalType.TIME)
        @Column(name = "END_TIME", length = 8)
        public Date getEndTime() {
            return this.endTime;
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

        @Temporal(TemporalType.TIME)
        @Column(name = "START_TIME", length = 8)
        public Date getStartTime() {
            return this.startTime;
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


        public void setEndTime(Date endTime) {
            this.endTime = endTime;
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

        public void setStartTime(Date startTime) {
            this.startTime = startTime;
        }

}
