package com.example.scheduler.objects;

import java.util.ArrayList;

public class Person {
    private String name;
    private ArrayList<Shift> workList;
    private String status;// administrator or normal user
    private String password;

    public Person(String name, String password, String status) {
        this.name = name;
        workList = new ArrayList<>();
        this.status = status;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Shift> getWorkList() {
        return workList;
    }

    public void setWorkList(ArrayList<Shift> workList) {
        this.workList = workList;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

