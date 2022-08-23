package com.example.scheduler.persistence;

import com.example.scheduler.objects.Person;

import java.util.ArrayList;

public interface IPersistenceAccess {
    /*******************************************************/
    /************************* CRUD ************************/
    /*******************************************************/
    void open(String dbPath);
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
