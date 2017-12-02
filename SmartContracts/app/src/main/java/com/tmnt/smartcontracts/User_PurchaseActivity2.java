package com.tmnt.smartcontracts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tmnt.smartcontracts.adapters.CropsListAdapter;
import com.tmnt.smartcontracts.adapters.CropsOrderListAdapter;
import com.tmnt.smartcontracts.models.CropModel;

import java.util.ArrayList;
import java.util.List;

public class User_PurchaseActivity2 extends AppCompatActivity {

    CropsOrderListAdapter cropsOrderListAdapter;
    CropModel c1 ,c2 ,c3;
    List<CropModel> cropList = new ArrayList<>();
    RecyclerView localCropList;
    LinearLayoutManager layoutManager;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(User_PurchaseActivity2.this, User_PurchaseActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__purchase2);

        c1 = new CropModel("Potato","100");
        c2 = new CropModel("Onion","150");
        c3 = new CropModel("Rajma","400");
        cropList.add(c1);
        cropList.add(c2);
        cropList.add(c3);

        localCropList = (RecyclerView) findViewById(R.id.crop_recycler_view_farmerx) ;
        cropsOrderListAdapter = new CropsOrderListAdapter(this, cropList);
        layoutManager = new LinearLayoutManager(this);
        localCropList.setLayoutManager(layoutManager);
        localCropList.setAdapter(cropsOrderListAdapter);
        cropsOrderListAdapter.notifyDataSetChanged();


    }
}
