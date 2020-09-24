package com.Management.feeTraining.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


import javax.persistence.*;


import java.util.List;
import java.util.Set;


@Entity
@Table(name = "roles")
//@JsonIgnoreProperties(value= {"user"})
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long role_id;

    @Enumerated(EnumType.STRING)
    private RoleName role_Name;


    public Role() {
    }

    public Role(long role_id, RoleName role_Name) {
        this.role_id = role_id;
        this.role_Name = role_Name;
    }

    public long getRole_id() {
        return role_id;
    }

    public void setRole_id(long role_id) {
        this.role_id = role_id;
    }

    public RoleName getRole_Name() {
        return role_Name;
    }

    public void setRole_Name(RoleName role_Name) {
        this.role_Name = role_Name;
    }


    //    @JsonIgnore
//    @JsonBackReference
//    @OneToMany(mappedBy ="roles",cascade = CascadeType.ALL)
//    @JoinTable(name="role_menus",
//    joinColumns = @JoinColumn(name="role_id"),
//    inverseJoinColumns = @JoinColumn(name = "menu_id"))
    //   private List<Menu> menus;

//    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JoinTable(name="role_menus",
//            joinColumns =@JoinColumn(name= "role_id"),
//            inverseJoinColumns =@JoinColumn(name= "menu_id"))
//    private List<Menu> menus;

    @JsonManagedReference
    @OneToMany(fetch=FetchType.EAGER,mappedBy = "roles", cascade = CascadeType.ALL)
    private Set<Menu> menus;

    @ManyToMany(fetch=FetchType.EAGER,mappedBy = "roles", cascade = CascadeType.ALL)
    private List<User> users;

//    @JsonManagedReference
//    @OneToMany(mappedBy = "roles", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private Set<User> users;
}
