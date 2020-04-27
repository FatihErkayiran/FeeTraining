package com.Management.feeTraining.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="menus")

public class Menu {

    @Id
    @GeneratedValue
    private long menu_id;

    @Enumerated(EnumType.STRING)
    private MenuType menuType;

    public Menu() {
    }

    public Menu(long menu_id, MenuType menuType) {
        this.menu_id = menu_id;
        this.menuType = menuType;
    }

    public long getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(long menu_id) {
        this.menu_id = menu_id;
    }

    public MenuType getMenuType() {
        return menuType;
    }

    public void setMenuType(MenuType menuType) {
        this.menuType = menuType;
    }

    @JsonIgnore
    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name="role_id",nullable = false)
    private Role roles;





}