package com.test.database.databasedemo.entity;


import org.hibernate.annotations.NamedQuery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
@Entity
@NamedQuery(name="find all user", query = " select p from Person p")
public class Person {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String location;
    private Date birth_Date;

    public Person(){

    }

    public Person(String name, String location, Date birth_Date) {
        this.name = name;
        this.location = location;
        this.birth_Date = birth_Date;
    }

    public Person(int id, String name, String location, Date birth_Date) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.birth_Date = birth_Date;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Date getBirth_Date() {
        return birth_Date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setBirth_Date(Date birth_Date) {
        this.birth_Date = birth_Date;
    }

    @Override
    public String toString() {
        return "\n Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", bithDate=" + birth_Date +
                '}';
    }
}
