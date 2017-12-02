package com.tmnt.smartcontracts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class FarmerProfile extends AppCompatActivity {

    TextView name, location, age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_profile);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(FarmerProfile.this, FarmerMainScreen.class);
        startActivity(i);
        finish();
    }
}
