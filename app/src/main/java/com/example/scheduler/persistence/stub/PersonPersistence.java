package com.example.scheduler.persistence.stub;

import com.example.scheduler.objects.Person;
import com.example.scheduler.persistence.IPersonPersistence;

import java.util.ArrayList;

public class PersonPersistence implements IPersonPersistence {
    private ArrayList<Person> people;

    public PersonPersistence() {
        people = new ArrayList<>();
    }

    /***********************
     *** Logic operations
     ********* CRUD********
     ************************/
    @Override
    public int addPerson(String name, String password, String group) {
        Person person = new Person(name, password, group);
        people.add(person);
        return people.size();
    }

    @Override
    public Person getPersonByName(String name) {
        Person res = null;
        int len = people.size();
        for (int i = 0; i < len; i++) {
            Person curr = people.get(i);
            if (curr.getName().equals(name)) {
                res = curr;
            }
        }
        return res;
    }

    @Override
    public void rename(String name, String newName) {
        Person curr = getPersonByName(name);
        curr.setName(newName);
    }

    @Override
    public void rePassword(String name, String newPassword) {
        Person curr = getPersonByName(name);
        curr.setPassword(newPassword);
    }

    @Override
    public void reStatus(String name, boolean status) {
        Person curr = getPersonByName(name);
        curr.setStatus(status);
    }

    @Override
    public boolean deletePerson(String name) {
        boolean delete = false;

        Person curr = getPersonByName(name);
        if (curr != null) {
            people.remove(curr);
            delete = true;
        }

        return delete;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    /***********************
     *** Override methods ***
     * *********************/

    @Override
    public void open(String dbPath) {
        Person p1 = new Person("A", "a", "1");
        Person p2 = new Person("B", "b", "1");
        Person p3 = new Person("C", "c", "1");
        Person p4 = new Person("D", "d", "2");
        Person p5 = new Person("E", "e", "2");
        Person p6 = new Person("F", "f", "3");

        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);
        people.add(p5);
        people.add(p6);

        System.out.println(dbPath + " has established successfully.");
    }

    @Override
    public void close() {
        System.out.println("DB portal closed.");
    }

    @Override
    public int addElement(String label) {
        return 0;
    }

    @Override
    public Object getElementByInfo(String label) {
        return null;
    }

    @Override
    public ArrayList<Object> getElement() {
        return null;
    }

    @Override
    public void updateInfo(String label, String newLabel) {

    }


    public boolean deleteElement(String label) {
        return false;
    }
}
