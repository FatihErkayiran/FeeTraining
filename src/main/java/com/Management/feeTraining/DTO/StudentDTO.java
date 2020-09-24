package com.Management.feeTraining.DTO;

import com.Management.feeTraining.Entities.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//@JsonIgnoreProperties(value={"user"})
public class StudentDTO {



    private long student_id;
    private String student_name;
    private String student_course;
    private int student_fee;
    private int student_paid;
    private int student_due;
    private String student_address;
    private String student_contact;
    private long user_id;
    private User user;

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

}
