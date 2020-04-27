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
    private String username;
    @NotBlank
    @Size(min=3,max=30)
    private String password;
    @NotBlank
    @Size(min=3,max=30)
    @NaturalId
    private String email;



    public long getUser_id() {
        return user_id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
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
