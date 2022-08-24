package com.example.scheduler.persistence.real;

import com.example.scheduler.objects.Person;
import com.example.scheduler.persistence.IPersistenceAccess;

import java.util.ArrayList;

public class PersonPersistenceDB implements IPersistenceAccess {
    private final String DBPATH;

    public PersonPersistenceDB(String dbPath) {
        DBPATH = dbPath;
    }


    public int addPerson(String name, String password, String group) {
        return 0;
    }


    public Person getPersonByName(String name) {
        return null;
    }


    public ArrayList<Person> getPeople() {
        return null;
    }


    public void rename(String name, String newName) {

    }


    public void rePassword(String name, String newPassword) {

    }


    public void reStatus(String name, boolean admin) {

    }


    public boolean deletePerson(String name) {
        return false;
    }

    @Override
    public void open(String dbPath) {
        System.out.println(dbPath+"(realDB) connection has established successfully.");
    }

    @Override
    public void close() {
        System.out.println("RealDB portal closed.");
    }


}
