package com.example.scheduler.business;

import com.example.scheduler.persistence.IPersistenceAccess;
import com.example.scheduler.persistence.real.PersonPersistenceDB;
import com.example.scheduler.persistence.stub.PersonPersistence;
import com.example.scheduler.presentation.MainActivity;

public class Service {
    private static IPersistenceAccess access = null;

    public static IPersistenceAccess createAccess(String dbName) {
        if (access == null) {
            access = new PersonPersistenceDB(dbName);
            access.open(MainActivity.getDBPathName());
        }
        return access;
    }

    public static IPersistenceAccess createAccess(IPersistenceAccess alternate) {
        if (access == null) {
            access = alternate;
            access.open(MainActivity.getDBPathName());
        }
        return access;
    }//end createAccess

}
