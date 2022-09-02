package com.example.scheduler.objects;

import java.util.ArrayList;

public class Person {
    private String name;
    private String group;
    private ArrayList<Shift> workList;
    private boolean admin;// administrator or normal user
    private String password;

    public Person(String name, String password,String group) {
        this.name = name;
        this.group = group;
        workList = new ArrayList<>();
        admin = false;
        this.password = password;
    }

    public Person(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public ArrayList<Shift> getWorkList() {
        return workList;
    }

    public void setWorkList(ArrayList<Shift> workList) {
        this.workList = workList;
    }

    public void setStatus(boolean status) {
        admin = status;
    }

    public boolean getStatus() {
        return admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

