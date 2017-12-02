package com.tmnt.smartcontracts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.tmnt.smartcontracts.adapters.CropsListAdapter;
import com.tmnt.smartcontracts.models.CropModel;

import java.util.ArrayList;
import java.util.List;

public class FarmerLandDetails extends AppCompatActivity {

    TextView name, location, age;
    CropModel c1 ,c2 ,c3;
    List<CropModel> cropList = new ArrayList<>();
    CropsListAdapter cropsListAdapter;
    RecyclerView localCropList;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_land_details);

        c1 = new CropModel("Potato","100");
        c2 = new CropModel("Onion","150");
        c3 = new CropModel("Rajma","400");
        cropList.add(c1);
        cropList.add(c2);
        cropList.add(c3);

        localCropList = (RecyclerView) findViewById(R.id.crop_recycler_view) ;
        cropsListAdapter = new CropsListAdapter(this, cropList);
        layoutManager = new LinearLayoutManager(this);
        localCropList.setLayoutManager(layoutManager);
        localCropList.setAdapter(cropsListAdapter);
        cropsListAdapter.notifyDataSetChanged();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(FarmerLandDetails.this , FarmerMainScreen.class );
        startActivity(i);
        finish();
    }
}
