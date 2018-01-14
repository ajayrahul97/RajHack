package com.tmnt.smartcontracts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tmnt.smartcontracts.adapters.CropsListAdapter;
import com.tmnt.smartcontracts.adapters.FarmersListAdapter;
import com.tmnt.smartcontracts.models.CropModel;
import com.tmnt.smartcontracts.models.FarmerModel;

import java.util.ArrayList;
import java.util.List;

public class User_PurchaseActivity extends AppCompatActivity {

    FarmerModel f1, f2 ,f3;
    List<FarmerModel> farmerModelList = new ArrayList<>();
    FarmersListAdapter farmersListAdapter;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<String> cropList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__purchase);

        cropList.add("Potato");
        cropList.add("Tomato");
        cropList.add("Onion");
        f1 = new FarmerModel("Ramu",cropList);
        f2 = new FarmerModel("Shamu",cropList);
        f3 = new FarmerModel("Daamu",cropList);
        farmerModelList.add(f1);
        farmerModelList.add(f2);
        farmerModelList.add(f3);

        recyclerView = (RecyclerView) findViewById(R.id.farmer_recycler_view) ;
        farmersListAdapter = new FarmersListAdapter(this, farmerModelList, new FarmersListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(FarmerModel farmerModel) {
                Intent i = new Intent(User_PurchaseActivity.this,User_PurchaseActivity2.class);
                startActivity(i);
            }
        });
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(farmersListAdapter);
        farmersListAdapter.notifyDataSetChanged();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(User_PurchaseActivity.this, UserMainScreen.class);
        startActivity(i);
        finish();
    }

}
