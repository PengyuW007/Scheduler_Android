package com.example.scheduler.persistence;

import com.example.scheduler.objects.Person;

import java.util.ArrayList;

public interface IPersistenceAccess {
    /*** Data Access ***/
    void open(String dbPath);
    void close();
    /*******************************************************/
    /************************* CRUD ************************/
    /*******************************************************/

    /*** CREATE ***/
    int addPerson(Person person);

    /*** READ ***/
    Person getPersonByName(String name);

    ArrayList<Person> getPeople();

    boolean isSame(String name,String group);

    /*** UPDATE ***/
    void rename(String name, String newName);

    void rePassword(String name, String newPassword);

    void reStatus(String name, boolean status);

    /*** DELETE ***/
    boolean deletePerson(String name);
}
