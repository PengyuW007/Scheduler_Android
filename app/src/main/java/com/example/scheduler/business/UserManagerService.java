package com.example.scheduler.business;

import com.example.scheduler.objects.Person;
import com.example.scheduler.persistence.IPersistenceAccess;
import com.example.scheduler.persistence.IPersonPersistence;
import com.example.scheduler.presentation.MainActivity;

import java.util.ArrayList;

public class UserManagerService {
    private IPersonPersistence access;

    public UserManagerService(){
       access = (IPersonPersistence) Service.getAccess(MainActivity.getDBPathName());
    }

    public Person addUser(String name,String password,String group){
        access.addPerson(name, password, group);
        return access.getPersonByName(name);
    }


}
