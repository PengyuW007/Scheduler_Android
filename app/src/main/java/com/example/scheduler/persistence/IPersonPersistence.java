package com.example.scheduler.persistence;

import com.example.scheduler.objects.Person;

import java.util.ArrayList;

public interface IPersonPersistence  {
    /*******************************************************/
    /************************* CRUD ************************/
    /*******************************************************/

    /*** Create ***/
    int addPerson(String name,String password,String group);

    /*** READ ***/
    Person getPersonByName(String name);
    ArrayList<Person> getPeople();

    /*** UPDATE ***/
    void rename(String newName);
    void rePassword(String name,String newPassword);
    void reStatus(String name);

    /*** DELETE ***/
    boolean deletePerson(String name);
}
