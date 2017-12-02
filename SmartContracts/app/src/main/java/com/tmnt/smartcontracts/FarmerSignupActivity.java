package com.tmnt.smartcontracts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FarmerSignupActivity extends AppCompatActivity {


    EditText fname, lname , email, password , cnf_password, aadhar, contact_no ;
    TextView btn_login;
    Button upload, signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        btn_login = (TextView) findViewById(R.id.link_login);
        fname = (EditText) findViewById(R.id.input_Fname);
        lname = (EditText) findViewById(R.id.input_Lname);
        email = (EditText) findViewById(R.id.input_email);
        password = (EditText) findViewById(R.id.input_password);
        cnf_password = (EditText) findViewById(R.id.input_cnf_password);
        aadhar = (EditText) findViewById(R.id.input_aadhar);
        contact_no = (EditText) findViewById(R.id.input_contact);
        upload = (Button) findViewById(R.id.btn_upload);
        signup = (Button) findViewById(R.id.btn_signup);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FarmerSignupActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(FarmerSignupActivity.this,"Dummy file uploaded !", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(FarmerSignupActivity.this, LoginActivity.class);
        startActivity(i);
        finish();
    }
}
