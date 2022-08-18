package com.example.scheduler.business;

import com.example.scheduler.objects.Person;
import com.example.scheduler.persistence.stub.PersonPersistence;

import java.util.ArrayList;

public class MainService {
    private ArrayList<Person> people;
    private PersonPersistence db;
    MainService ms;

    public MainService(){
        people = db.getPeople();
    }
}
