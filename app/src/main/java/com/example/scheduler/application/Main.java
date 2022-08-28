package com.example.scheduler.application;

import com.example.scheduler.presentation.CLI;

public class Main {

    public static final String dbName = "Scheduler";
    private static String dbPath = "database/Scheduler";

    public static void main(String[] args) {
        startUp();
        CLI.run();
        shutDown();
        System.out.println("All done");
    }

    public static void startUp() {
        Service.createAccess(dbName);
    }

    public static void shutDown() {
        Service.closeAccess();
    }

    public static String getDBPathName() {
        //actually,get dbPath
        String res = "";
        if (dbPath != null) {
            res = dbPath;
        } else {
            res = dbName;
        }
        return res;
    }

    public static void setDBPathName(String pathName) {
        System.out.println("Setting DB path to: " + pathName);
        dbPath = pathName;
    }
}
