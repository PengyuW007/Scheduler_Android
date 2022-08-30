package com.example.scheduler.business;

import com.example.scheduler.application.Main;
import com.example.scheduler.application.Service;
import com.example.scheduler.objects.Person;
import com.example.scheduler.persistence.IPersistenceAccess;

import java.util.ArrayList;

public class UserManagerService {
    private IPersistenceAccess access;

    public UserManagerService() {
        access =  Service.getAccess(Main.dbName);
    }

    public Person addUser(Person person) {
        access.addPerson(person);
        return person;
    }

    public Person getUserByName(String name) {
        return access.getPersonByName(name);
    }

    public boolean isUnique(String name, String group) {
        return access.isSame(name, group);
    }

    public Person rename(String name, String newName) {
        access.rename(name, newName);
        return access.getPersonByName(newName);
    }

    public Person rePassword(String name, String newPassword) {
        access.rePassword(name, newPassword);
        return access.getPersonByName(name);
    }

    public Person reStatus(String name, boolean status) {
        access.reStatus(name, status);
        return access.getPersonByName(name);
    }

    public boolean deleteUser(String name) {
        return access.deletePerson(name);
    }

    public ArrayList<Person>getPeople(){
        return access.getPeople();
    }
}
