package com.example.scheduler.presentation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scheduler.R;
import com.example.scheduler.business.UserManagerService;
import com.example.scheduler.objects.Person;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private String[] sections;
    private NumberPicker sectionsPicker;
    private EditText name, password;
    private Button confirm;
    private String nameGet, passwordGet, sectionGet;
    private UserManagerService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        sections = getResources().getStringArray(R.array.sections);
        userService = new UserManagerService();

        initUI();

        name.setOnClickListener(this);
        password.setOnClickListener(this);
        confirm.setOnClickListener(this);
    }

    private void initUI() {
        /*** Edit Text ***/
        name = (EditText) findViewById(R.id.signUp_username_text);
        password = (EditText) findViewById(R.id.signUp_password_text);
        /*** Number picker ***/
        sectionsPicker = (NumberPicker) findViewById(R.id.number_picker_sections);
        sectionsPicker.setMinValue(0);
        sectionsPicker.setMaxValue(6);
        sectionsPicker.setDisplayedValues(sections);

        /*** Confirm button ***/
        confirm = findViewById(R.id.signUp_login_button);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        if (view.getId() == R.id.signUp_login_button) {
            dataReceivedDB(intent);
        }
    }

    private void dataReceivedDB(Intent intent) {
        Person person;
        /*** data received ***/
        nameGet = name.getText().toString();
        if (nameGet.matches("")) {
            Toast.makeText(RegisterActivity.this, "Please type in your name!", Toast.LENGTH_LONG).show();
        } else {
            passwordGet = password.getText().toString();
            if (passwordGet.matches("")) {
                Toast.makeText(RegisterActivity.this, "Please type in your password!", Toast.LENGTH_LONG).show();
            } else {

                sectionGet = sections[sectionsPicker.getValue()];
                Log.i("name_here", nameGet);
                Log.i("password_here", passwordGet);
                Log.i("section_here", sectionGet);

                boolean isUnique = userService.isSame(nameGet, sectionGet);

                if (isUnique) {
                    person = new Person(nameGet, passwordGet, sectionGet);
                    userService.addUser(person);

                    intent.putExtra("register_name_receive", nameGet);
                    intent.putExtra("register_password_receive", passwordGet);
                    intent.putExtra("register_section_receive", sectionGet);
                    startActivity(intent);
                } else {
                    Toast.makeText(RegisterActivity.this, "User name has existed, please change another name!", Toast.LENGTH_LONG).show();
                }

            }
        }
    }//end dataReceivedDB

    private void closeKeyboard(View view) {
        InputMethodManager imm =(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }

    private void dataReceived(Intent intent) {
        String nameStr = "AA", passwordStr = "aa", groupGet = "11";
        boolean isUnique = userService.isSame(nameStr, groupGet);

        System.out.println("Size before: " + userService.getPeople().size());
        if (isUnique) {
            Person person = new Person(nameStr, passwordStr, groupGet);
            userService.addUser(person);
            System.out.println("Size after: " + userService.getPeople().size());
        }
    }
}
