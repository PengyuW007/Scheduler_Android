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

    }

    @Override
    public int addElement(String label) {
        return 0;
    }

    @Override
    public Object getElementByInfo(String label) {
        return null;
    }

    @Override
    public ArrayList<Object> getElement() {
        return null;
    }

    @Override
    public void updateInfo(String label, String newLabel) {

    }

    @Override
    public boolean deleteElement(String label) {
        return false;
    }


}
