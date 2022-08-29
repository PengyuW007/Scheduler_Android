package com.example.scheduler.persistence.real;

import com.example.scheduler.objects.Person;
import com.example.scheduler.persistence.IPersistenceAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonPersistenceDB implements IPersistenceAccess {
    private Statement st1, st2, st3;
    private Connection connection;
    private ResultSet rs1, rs2, rs3, rs4, rs5;

    private final String DBPATH;
    private String dbType;

    private ArrayList<Person> people;

    private String cmdStr;
    private int updateCount;
    private String result;
    private static String EOF = " ";

    public PersonPersistenceDB(String dbPath) {
        DBPATH = dbPath;
    }


    public int addPerson(Person person) {
        String values;

        try {
            values = "'" + person.getName() + "', '" + person.getPassword() + "', '" + person.getGroup() + "',0";
            cmdStr = "Insert into PEOPLE " + " Values(" + values + ")";
            updateCount = st1.executeUpdate(cmdStr);
            result = checkWarning(st1, updateCount);
        } catch (Exception e) {
            result = processSQLError(e);
        }
        return peopleCount();
    }//end addPerson

    private int peopleCount() {
        cmdStr = "Select Count(*) as total from People";
        int count = 0;

        try {
            rs2 = st1.executeQuery(cmdStr);
            while (rs2.next()) {
                count = rs2.getInt(1);
            }

            //or not use while loop, only, count = rsTemp.getInt("total");
        } catch (Exception e) {
            processSQLError(e);
        }
        return count;
    }//end peopleCount

    public Person getPersonByName(String name) {
        int len = people.size();
        Person res = null;
        for (int i = 0; i < len; i++) {
            Person curr = people.get(i);
            if (curr.getName().equalsIgnoreCase(name)) {
                res = curr;
            }
        }
        return res;
    }//end getPersonByName


    public ArrayList<Person> getPeople() {
        Person person;
        String name = EOF, password = EOF, group = EOF;

        people = new ArrayList<>();

        try {
            cmdStr = "Select * from People";
            rs5 = st3.executeQuery(cmdStr);

            while (rs5.next()) {
                name = rs5.getString("Name");
                password = rs5.getString("Password");
                group = rs5.getString("Group");
                person = new Person(name, password, group);
                people.add(person);
            }
            rs5.close();
        } catch (Exception e) {
            processSQLError(e);
        }
        return people;
    }//end getPeople

    @Override
    public boolean isUnique(String name, String group) {
        String where;
        boolean res = false;
        try {
            where = "Name='" + name + "' and Group='" + group + "';";
            cmdStr = "Select * from PEOPLE where " + where;
            updateCount = st2.executeUpdate(cmdStr);
            if (updateCount == 0) {
                res = true;
            }
        } catch (Exception e) {
            processSQLError(e);
        }
        return res;
    }//end isUnique

    @Override
    public void rename(String name, String newName) {
        String values;
        String where;

        try {
            values = "Name='" + newName + "'";
            where = "where Name='" + name + "'";
            cmdStr = "Update People " + " Set " + values + " " + where;
            updateCount = st1.executeUpdate(cmdStr);
            checkWarning(st1, updateCount);

            Person curr = getPersonByName(name);
            curr.setName(newName);
        } catch (Exception e) {
            processSQLError(e);
        }
    }//end rename

    @Override
    public void rePassword(String name, String newPassword) {
        String values;
        String where;

        try {
            values = "Password='" + newPassword + "'";
            where = "where Name='" + name + "'";
            cmdStr = "Update People " + " Set " + values + " " + where;
            updateCount = st1.executeUpdate(cmdStr);
            checkWarning(st1, updateCount);

            Person curr = getPersonByName(name);
            curr.setPassword(newPassword);
        } catch (Exception e) {
            processSQLError(e);
        }
    }//end rePassword

    @Override
    public void reStatus(String name, boolean admin) {
        String values;
        String where;
        int status;

        try {
            if (admin) {
                status = 1;
            } else {
                status = 0;
            }
            values = "Admin=" + status;
            where = "where Name='" + name + "'";
            cmdStr = "Update People " + " Set " + values + " " + where;
            updateCount = st1.executeUpdate(cmdStr);
            checkWarning(st1, updateCount);

            Person curr = getPersonByName(name);
            curr.setStatus(admin);
        } catch (Exception e) {
            processSQLError(e);
        }
    }//end reStatus

    @Override
    public boolean deletePerson(String name) {
        String values;
        boolean deleted = false;
        try {
            values = name;
            cmdStr = "Delete from People where Name=" + values;
            //System.out.println(cmdString);
            updateCount = st1.executeUpdate(cmdStr);
            checkWarning(st1, updateCount);

            Person curr = getPersonByName(name);
            people.remove(curr);

            deleted = true;
        } catch (Exception e) {
            processSQLError(e);
        }
        return deleted;
    }//end deletePerson

    @Override
    public void open(String dbPath) {
        String url;
        try {
            // Setup for HSQL
            dbType = "HSQL";
            Class.forName("org.hsqldb.jdbcDriver").newInstance();
            url = "jdbc:hsqldb:file:" + dbPath; // stored on disk mode
            connection = DriverManager.getConnection(url, "SA", "");
            st1 = connection.createStatement();
            st2 = connection.createStatement();
            st3 = connection.createStatement();

        } catch (Exception e) {
            processSQLError(e);
        }
        System.out.println("Opened "+dbType+" and "+dbPath + "(realDB) connection has established successfully.");
    }//end open

    @Override
    public void close() {
        try {    // commit all changes to the database
            cmdStr = "shutdown compact";
            rs2 = st1.executeQuery(cmdStr);
            connection.close();
        } catch (Exception e) {
            processSQLError(e);
        }
        System.out.println("RealDB portal closed.");
    }//end close

    public String checkWarning(Statement st, int updateCount) {
        String result;

        result = null;
        try {
            SQLWarning warning = st.getWarnings();
            if (warning != null) {
                result = warning.getMessage();
            }
        } catch (Exception e) {
            result = processSQLError(e);
        }
        if (updateCount != 1) {
            result = "Tuple not inserted correctly.";
        }
        return result;
    }//end checkWarning

    public String processSQLError(Exception e) {
        String result = "*** SQL Error: " + e.getMessage();

        // Remember, this will NOT be seen by the user!
        e.printStackTrace();

        return result;
    }//end processSQLError
}