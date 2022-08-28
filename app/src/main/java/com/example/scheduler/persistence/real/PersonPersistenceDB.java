package com.example.scheduler.persistence.real;

import com.example.scheduler.objects.Person;
import com.example.scheduler.persistence.IPersistenceAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            values = person.getName() + ", '" + person.getPassword()
                    + "', '" + person.getGroup()
                    + "'";
            cmdStr = "Insert into People " + " Values(" + values + ")";
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
    }

    public Person getPersonByName(String name) {
        return null;
    }


    public ArrayList<Person> getPeople() {
        return null;
    }


    public void rename(String name, String newName) {

    }


    public void rePassword(String name, String newPassword) {

    }


    public void reStatus(String name, boolean admin) {

    }


    public boolean deletePerson(String name) {
        return false;
    }

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

            /*** Alternate setups for different DB engines, just given as examples. Don't use them. ***/

            /*
             * // Setup for SQLite. Note that this is undocumented and is not guaranteed to work.
             * // See also: https://github.com/SQLDroid/SQLDroid
             * dbType = "SQLite";
             * Class.forName("SQLite.JDBCDriver").newInstance();
             * url = "jdbc:sqlite:" + dbPath;
             * c1 = DriverManager.getConnection(url);
             *
             * ... create statements
             */

            /*** The following two work on desktop builds: ***/

            /*
             * // Setup for Access
             * dbType = "Access";
             * Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
             * url = "jdbc:odbc:SC";
             * c1 = DriverManager.getConnection(url,"userid","userpassword");
             *
             * ... create statements
             */

            /*
             * //Setup for MySQL
             * dbType = "MySQL";
             * Class.forName("com.mysql.jdbc.Driver");
             * url = "jdbc:mysql://localhost/database01";
             * c1 = DriverManager.getConnection(url, "root", "");
             *
             * ... create statements
             */
        } catch (Exception e) {
            processSQLError(e);
        }
        System.out.println(dbPath + "(realDB) connection has established successfully.");
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
    }

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
    }

    public String processSQLError(Exception e) {
        String result = "*** SQL Error: " + e.getMessage();

        // Remember, this will NOT be seen by the user!
        e.printStackTrace();

        return result;
    }

}
