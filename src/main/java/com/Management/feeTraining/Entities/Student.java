package com.Management.feeTraining.Entities;
import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long student_id;
        private  String student_name;
        private  String student_email;
        private String student_course;
        private int student_fee;
        private int student_paid;
        private int student_due;
        private String student_address;
        private String student_contact;


        public long getStudent_id() {
            return student_id;
        }
        public void setStudent_id(long student_id) {
            this.student_id = student_id;
        }

        public String getStudent_course() {
            return student_course;
        }
        public void setStudent_course(String student_course) {
            this.student_course = student_course;
        }
        public int getStudent_fee() {
            return student_fee;
        }
        public void setStudent_fee(int student_fee) {
            this.student_fee = student_fee;
        }
        public int getStudent_paid() {
            return student_paid;
        }
        public void setStudent_paid(int student_paid) {
            this.student_paid = student_paid;
        }
        public int getStudent_due() {
            return student_due;
        }
        public void setStudent_due(int student_due) {
            this.student_due = student_due;
        }
        public String getStudent_address() {
            return student_address;
        }
        public void setStudent_address(String student_address) {
            this.student_address = student_address;
        }
        public String getStudent_contact() {
            return student_contact;
        }
        public void setStudent_contact(String student_contact) {
            this.student_contact = student_contact;
        }
        public String getStudent_name() {
            return student_name;
        }
        public void setStudent_name(String student_name) {
            this.student_name = student_name;
        }
        public String getStudent_email() {
            return student_email;
        }
        public void setStudent_email(String student_email) {
            this.student_email = student_email;
        }


        //    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

}
