package com.example.scheduler.persistence.real;

import com.example.scheduler.objects.Person;
import com.example.scheduler.persistence.IPersonPersistence;

import java.util.ArrayList;

public class PersonPersistenceHSQLDB implements IPersonPersistence {

    @Override
    public int addPerson(String name, String password, String group) {
        return 0;
    }

    @Override
    public Person getPersonByName(String name) {
        return null;
    }

    @Override
    public ArrayList<Person> getPeople() {
        return null;
    }

    @Override
    public void rename(String name, String newName) {

    }

    @Override
    public void rePassword(String name, String newPassword) {

    }

    @Override
    public void reStatus(String name, boolean admin) {

    }

    @Override
    public boolean deletePerson(String name) {
        return false;
    }
}
