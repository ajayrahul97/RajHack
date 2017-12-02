package com.tmnt.smartcontracts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    TextView signup, email, password;
    Button login;
    CheckBox fcheck, ucheck;
    boolean farmer_check_true = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (TextView) findViewById(R.id.input_email);
        password = (TextView) findViewById(R.id.input_password);
        login = (Button) findViewById(R.id.btn_login);
        signup = (TextView) findViewById(R.id.link_signup);
        fcheck = (CheckBox) findViewById(R.id.farmer_check);
        ucheck = (CheckBox) findViewById(R.id.user_check);


        if (fcheck.isChecked()) {
            ucheck.setChecked(false);
            farmer_check_true = true;
        }

        if (ucheck.isChecked()) {
            fcheck.setChecked(false);
            farmer_check_true = false;
        }

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, FarmerSignupActivity.class);
                startActivity(i);
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (farmer_check_true) {
                    Intent i = new Intent(LoginActivity.this, FarmerMainScreen.class);
                    startActivity(i);
                    finish();
                } else {
                    Intent i = new Intent(LoginActivity.this, UserMainScreen.class);
                    startActivity(i);
                    finish();
                }

            }
        });

        fcheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (fcheck.isChecked()) {
                    ucheck.setChecked(false);
                    farmer_check_true = true;
                }else{
                    ucheck.setChecked(true);
                    farmer_check_true = false;
                }
            }
        });

        ucheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ucheck.isChecked()) {
                    fcheck.setChecked(false);
                    farmer_check_true = false;
                }else{
                    fcheck.setChecked(true);
                    farmer_check_true = true;
                }
            }
        });


    }
}
