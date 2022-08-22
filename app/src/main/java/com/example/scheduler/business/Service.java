package com.example.scheduler.business;

import com.example.scheduler.persistence.IPersistenceAccess;
import com.example.scheduler.persistence.real.PersonPersistenceDB;
import com.example.scheduler.persistence.stub.PersonPersistence;
import com.example.scheduler.presentation.MainActivity;

public class Service {
    private static IPersistenceAccess access = null;

    public static IPersistenceAccess createAccess(boolean real){
        if(access==null){
            //for real DB or fake DB
            if(real){
                access = new PersonPersistenceDB(MainActivity.getDBPathName());
            }else{
                access = new PersonPersistence();
            }
        }
        return access;
    }//end createAccess

}
