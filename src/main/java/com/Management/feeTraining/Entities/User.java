package com.Management.feeTraining.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "user")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;
    @NotBlank
    @Size(min = 3, max = 30)
    private String name;
    @NotBlank
    @Size(min = 3, max = 30)
    private String password;
    @NotBlank
    @Size(min = 3, max = 30)
    @NaturalId
    private String email;
    @NotBlank
    @Size(min = 3, max = 30)
    @Column(name = "address")
    private String address;
    @NotBlank
    @Size(min = 3, max = 30)
    @Column(name = "contact")
    private String contact;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;



    @JsonManagedReference
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Student> students;






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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
//    @JsonIgnore
//    @JsonBackReference
//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name="role_id",nullable = false)
//    private Role roles;




//    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
//    private List<Accountant> accountants=new ArrayList<>();
//

//    @OneToMany(mappedBy="user",cascade = CascadeType.ALL)
//    private List<Admin> admins=new ArrayList<>();


}
