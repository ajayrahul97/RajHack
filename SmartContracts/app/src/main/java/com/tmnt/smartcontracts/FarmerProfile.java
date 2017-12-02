package com.tmnt.smartcontracts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.tmnt.smartcontracts.adapters.UsersListAdapter;
import com.tmnt.smartcontracts.models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class FarmerProfile extends AppCompatActivity {

    TextView name, location, age;
    List<UserModel> userModelList = new ArrayList<>();
    UsersListAdapter usersListAdapter;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    UserModel c1, c2, c3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_profile);


        c1 = new UserModel("Suresh", "100");
        c2 = new UserModel("Ramesh", "150");
        c3 = new UserModel("Joyesh", "400");
        userModelList.add(c1);
        userModelList.add(c2);
        userModelList.add(c3);

        recyclerView = (RecyclerView) findViewById(R.id.user_recycler_view);
        usersListAdapter = new UsersListAdapter(this, userModelList);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(usersListAdapter);
        usersListAdapter.notifyDataSetChanged();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(FarmerProfile.this, FarmerMainScreen.class);
        startActivity(i);
        finish();
    }
}
