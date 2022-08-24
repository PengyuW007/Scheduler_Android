package com.example.scheduler.business;

import com.example.scheduler.objects.Person;
import com.example.scheduler.persistence.IPersonPersistence;
import com.example.scheduler.presentation.MainActivity;

public class UserManagerService {
    private final IPersonPersistence access;

    public UserManagerService() {
        access = (IPersonPersistence) Service.getAccess(MainActivity.getDBPathName());
    }

    public Person addUser(String name, String password, String group) {
        access.addPerson(name, password, group);
        return access.getPersonByName(name);
    }

    public Person getPersonByName(String name) {
        return access.getPersonByName(name);
    }

    public boolean isUnique(String name, String group) {
        return access.isUnique(name, group);
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
}
