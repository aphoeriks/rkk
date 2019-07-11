package com.accenture.rkk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
    @Id
    public int id;
    @Column
    public String user;
    @Column
    public String address;
}
