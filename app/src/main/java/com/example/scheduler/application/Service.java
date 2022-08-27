package com.example.scheduler.application;

import com.example.scheduler.persistence.IPersistenceAccess;
import com.example.scheduler.persistence.real.PersonPersistenceDB;
import com.example.scheduler.persistence.stub.PersonPersistence;
import com.example.scheduler.presentation.MainActivity;

public class Service {
    private static IPersistenceAccess access = null;

    public static IPersistenceAccess createAccess(String dbName) {
        if (access == null) {
            access = new PersonPersistenceDB(dbName);
            access.open(Main.getDBPathName());
        }
        return access;
    }//end createAccess

    public static IPersistenceAccess createAccess(IPersistenceAccess alternate) {
        if (access == null) {
            access = alternate;
            access.open(Main.getDBPathName());
        }
        return access;
    }//end createAccess

    public static IPersistenceAccess getAccess(String dbName) {
        if (access == null) {
            System.out.println("Connection to "+dbName+" data access has not been established.");
            System.exit(1);
        }
        return access;
    }//end getAccess

    public static void closeAccess() {
        if (access != null) {
            access.close();
        }
        access = null;//set it to null to close
    }

}
