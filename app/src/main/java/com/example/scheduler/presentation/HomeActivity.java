package com.example.scheduler.presentation;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HomeActivity extends AppCompatActivity {

    // MySQL Connection Details
    // 10.0.2.2 is the IP used by the Android Emulator to reach your computer's localhost
    private static final String DB_URL = "jdbc:mysql://10.0.2.2:3306/your_database_name";
    private static final String USER = "your_username";
    private static final String PASS = "your_password";

    private TextView statusText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Start the MySQL connection process
        fetchDataFromMySQL();
    }

    private void fetchDataFromMySQL() {
        // Create a background thread executor
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {
            // --- BACKGROUND THREAD ---
            String resultMessage;
            try {
                // 1. Load the MySQL Driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // 2. Establish Connection
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

                // 3. Execute a simple query
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT VERSION()");

                if (resultSet.next()) {
                    resultMessage = "Connected! MySQL Version: " + resultSet.getString(1);
                } else {
                    resultMessage = "Connected, but query failed.";
                }

                conn.close();

            } catch (Exception e) {
                Log.e("MySQL_ERROR", "Connection failed", e);
                resultMessage = "Error: " + e.getMessage();
            }

            // --- SWITCH BACK TO UI THREAD ---
            String finalResult = resultMessage;
            handler.post(() -> {
                statusText.setText(finalResult);
                Toast.makeText(HomeActivity.this, finalResult, Toast.LENGTH_LONG).show();
            });
        });
    }
}