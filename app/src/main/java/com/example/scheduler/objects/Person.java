package com.example.scheduler.objects;

import java.util.ArrayList;

public class Person {
    private String name;
    private ArrayList<Shift>workList;

    public Person(String name){
        this.name = name;
        workList = new ArrayList<>();
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
}
