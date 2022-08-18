package com.example.scheduler.persistence.stub;

import com.example.scheduler.objects.Person;
import com.example.scheduler.persistence.IPersonPersistence;

import java.util.ArrayList;

public class PersonPersistence implements IPersonPersistence {
    private ArrayList<Person> people;

    public PersonPersistence() {
        people = new ArrayList<>();
        setDB();
    }

    /*** Logic operations ***/

    @Override
    public int addPerson(String name, String password,String group) {
        Person person = new Person(name, password,group);
        people.add(person);
        return people.size();
    }

    @Override
    public Person getPersonByName(String name) {
        return null;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    @Override
    public void rename(String newName) {

    }

    @Override
    public void rePassword(String name, String newPassword) {

    }

    @Override
    public void reStatus(String name) {

    }

    @Override
    public boolean deletePerson(String name) {
        return false;
    }

    public void setDB() {
        Person p1 = new Person("A", "a","1");
        Person p2 = new Person("B", "b","1");
        Person p3 = new Person("C", "c","1");
        Person p4 = new Person("D", "d","2");
        Person p5 = new Person("E", "e","2");
        Person p6 = new Person("F", "f","3");
        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);
        people.add(p5);
        people.add(p6);
    }
}
