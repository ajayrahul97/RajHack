package com.tmnt.smartcontracts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.tmnt.smartcontracts.adapters.CropsListAdapter;
import com.tmnt.smartcontracts.models.CropModel;

import java.util.ArrayList;
import java.util.List;

public class FarmerLandDetails extends AppCompatActivity {

    TextView name, location , age;
    List<CropModel> cropModelList = new ArrayList<>();
    CropsListAdapter cropsListAdapter;
    RecyclerView localCropList;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_land_details);
        localCropList = (RecyclerView) findViewById(R.id.crop_recycler_view) ;
        cropsListAdapter = new CropsListAdapter(this, cropModelList);
        layoutManager = new LinearLayoutManager(this);
        localCropList.setLayoutManager(layoutManager);
        localCropList.setAdapter(cropsListAdapter);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(FarmerLandDetails.this , FarmerMainScreen.class );
        startActivity(i);
        finish();
    }
}
