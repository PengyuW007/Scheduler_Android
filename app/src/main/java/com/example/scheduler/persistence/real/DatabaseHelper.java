package com.example.scheduler.persistence.real; // Ensure this matches your actual package name

import android.os.Handler;
import android.os.Looper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DatabaseHelper {

    // 1. Connection Details
    // Use "10.0.2.2" if using the Android Emulator to connect to your laptop's MySQL
    // Use your laptop's actual IP (e.g., 192.168.1.5) if using a physical phone
    private static final String URL = "jdbc:mysql://10.0.2.2:3306/your_database_name";
    private static final String USER = "your_username";
    private static final String PASS = "your_password";

    // Executor for background tasks (MySQL cannot run on the UI thread)
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private final Handler mainThreadHandler = new Handler(Looper.getMainLooper());

    // Interface for callbacks to update the UI after database work is done
    public interface DatabaseCallback<T> {
        void onComplete(T result);
        void onError(Exception e);
    }

    /**
     * Establishes a connection to the MySQL database.
     */
    private Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASS);
    }

    /**
     * Example Method: Execute a query in the background
     */
    public void executeQueryExample(DatabaseCallback<String> callback) {
        executorService.execute(() -> {
            try (Connection conn = connect()) {
                // Example: Just checking if connection is valid
                if (conn != null && !conn.isClosed()) {
                    // Perform your SQL logic here
                    // ResultSet rs = conn.createStatement().executeQuery("SELECT...");

                    String result = "Connected to MySQL successfully!";

                    // Return result to the Main UI Thread
                    mainThreadHandler.post(() -> callback.onComplete(result));
                }
            } catch (Exception e) {
                mainThreadHandler.post(() -> callback.onError(e));
            }
        });
    }
}