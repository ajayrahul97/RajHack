package com.tmnt.smartcontracts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserMainScreen extends AppCompatActivity {

    Button invest, current_status;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(UserMainScreen.this , LoginActivity.class );
        startActivity(i);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main_screen);
        invest = (Button)findViewById(R.id.btn_invest);
        current_status = (Button)findViewById(R.id.btn_user_profile);

        invest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(UserMainScreen.this, UserInvest.class);
                startActivity(i);
                finish();
            }
        });

        current_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserMainScreen.this, User_PurchaseActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
