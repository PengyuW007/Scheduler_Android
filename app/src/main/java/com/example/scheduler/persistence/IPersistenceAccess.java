package com.example.scheduler.persistence;

import java.util.ArrayList;

public interface IPersistenceAccess {
    /*** Data Access ***/
    void open(String dbPath);
    void close();
}
