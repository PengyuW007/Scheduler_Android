package com.example.scheduler.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;

import com.example.scheduler.R;
import com.example.scheduler.application.Main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        copyDatabaseToDevice();
        setContentView(R.layout.activity_main);
        Main.startUp();
        initializeUI();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Main.shutDown();
    }

    private void copyDatabaseToDevice() {
        final String DB_PATH = "db";

        String[] assetNames;
        Context context = getApplicationContext();
        File dataDirectory = context.getDir(DB_PATH, Context.MODE_PRIVATE);
        AssetManager assetManager = getAssets();

        try {

            assetNames = assetManager.list(DB_PATH);
            for (int i = 0; i < assetNames.length; i++) {
                assetNames[i] = DB_PATH + "/" + assetNames[i];
            }

            copyAssetsToDirectory(assetNames, dataDirectory);

            Main.setDBPathName(dataDirectory.toString() + "/" + Main.dbName);

        } catch (IOException ioe) {
            Messages.warning(this, "Unable to access application data: " + ioe.getMessage());
        }
    }//end copyDatabaseToDevice

    public void copyAssetsToDirectory(String[] assets, File directory) throws IOException {
        AssetManager assetManager = getAssets();

        for (String asset : assets) {
            String[] components = asset.split("/");
            String copyPath = directory.toString() + "/" + components[components.length - 1];
            char[] buffer = new char[1024];
            int count;

            File outFile = new File(copyPath);

            if (!outFile.exists()) {
                InputStreamReader in = new InputStreamReader(assetManager.open(asset));
                FileWriter out = new FileWriter(outFile);

                count = in.read(buffer);
                while (count != -1) {
                    out.write(buffer, 0, count);
                    count = in.read(buffer);
                }

                out.close();
                in.close();
            }
        }
    }//end copyAssetsToDirectory

    private void initializeUI() {
        // Button reactions //
        findViewById(R.id.register_button).setOnClickListener(this);
        findViewById(R.id.signIn_button).setOnClickListener(this);
    }//end initializeUI

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        if (view.getId() == R.id.register_button) {
            intent.setClass(getApplicationContext(), RegisterActivity.class);
        } else if (view.getId() == R.id.signIn_button) {
            intent.setClass(getApplicationContext(), SignInActivity.class);
        }
        startActivity(intent);
    }


}