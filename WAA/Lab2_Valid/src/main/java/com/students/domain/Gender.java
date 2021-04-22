package com.students.domain;

public class Gender {
    private int id;
    private String name;

    public Gender(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
