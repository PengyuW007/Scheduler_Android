package com.example.scheduler.persistence;

import java.util.ArrayList;

public interface IPersistenceAccess {
    /*** Data Access ***/
    void open(String dbPath);
    void close();

    /*******************************************************/
    /************************* CRUD ************************/
    /*******************************************************/

    /*** CREATE ***/
    int addElement(String label);

    /*** READ ***/
    Object getElementByInfo(String label);

    ArrayList<Object> getElement();

    /*** UPDATE ***/
    void updateInfo(String label, String newLabel);

    /*** DELETE ***/
    boolean deleteElement(String label);
}
