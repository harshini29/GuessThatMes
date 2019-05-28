package com.example.guessthatmess;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button buttonLogin,buttonSignup;
    private EditText txtEmail,txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonLogin = findViewById(R.id.login_id);
        buttonSignup = findViewById(R.id.signup_id);

        txtEmail = findViewById(R.id.username_id);
        txtPassword = findViewById(R.id.password_id);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(getApplication(),GameZoneActivity.class);
                startActivity(intent);

            }
        });

        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(getApplication(), SignupActivity.class);
                startActivity(intent);

            }
        });
    }

}