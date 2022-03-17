package com.example.android.recyclerview;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView gotoRegister;
        gotoRegister = (TextView) findViewById(R.id.gotoRegister);

        gotoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(registerIntent);
            }
        });


        Button button;
        button = (Button) findViewById(R.id.LoginButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText e1, e2;
                String uname, pass;

                e1 = (EditText) findViewById(R.id.edt_userName);
                e2 = (EditText) findViewById(R.id.edt_password);

                uname = e1.getText().toString();
                pass = e2.getText().toString();

                if (uname.equals("arnav") && pass.equals("123")) {
                    Intent profileIntent = new Intent(LoginActivity.this, ProfileActivity.class);
                    startActivity(profileIntent);

                }
            }

        });


    }
}
