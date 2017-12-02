package com.tmnt.smartcontracts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class FarmerMainScreen extends AppCompatActivity {

    Button land_details, current_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_main_screen);
        land_details = (Button) findViewById(R.id.btn_land_details);
        current_status = (Button) findViewById(R.id.btn_farm_status);

        land_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FarmerMainScreen.this, FarmerLandDetails.class);
                startActivity(i);
                finish();
            }
        });

        current_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FarmerMainScreen.this, FarmerProfile.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(FarmerMainScreen.this, LoginActivity.class);
        startActivity(i);
        finish();
    }
}
