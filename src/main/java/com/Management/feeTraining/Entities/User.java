package com.Management.feeTraining.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="user")

public class User {

    @Id
    private long user_id;
    @NotBlank
    @Size(min=3,max=30)
    private String name;
    @NotBlank
    @Size(min=3,max=30)
    private String password;
    @NotBlank
    @Size(min=3,max=30)
    @NaturalId
    private String email;
    @NotBlank
    @Size(min=3,max=30)
    @Column(name="address")
    private String address;
    @NotBlank
    @Size(min=3,max=30)
    @Column(name="contact")
    private String contact;
    private long role_id;
    private String student_course;
    private int student_fee;
    private int student_paid;
    private int student_due;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }


    public long getUser_id() {
        return user_id;
    }

    public String getName() {
        return name;
    }


    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
   // @JoinColumn(name="role_id",nullable = false)
    @JoinTable(name="user_roles",
            joinColumns =@JoinColumn(name= "user_id"),
            inverseJoinColumns =@JoinColumn(name= "role_id"))

    private Set<Role> roles;





//    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
//    private List<Accountant> accountants=new ArrayList<>();
//
//    @OneToMany(mappedBy="user",cascade = CascadeType.ALL)
//    private List<Student> students=new ArrayList<>();
//
//    @OneToMany(mappedBy="user",cascade = CascadeType.ALL)
//    private List<Admin> admins=new ArrayList<>();




}
