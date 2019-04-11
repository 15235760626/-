package com.hibernate.entity;

import javax.management.relation.Role;
import java.util.HashSet;
import java.util.Set;

/**
 * @author :Mr.Xu
 * Date    :2019-4-9
 */
public class Book {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book() {
    }

    public Book(String name) {
        this.name = name;
    }

    public Book(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
