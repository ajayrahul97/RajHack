package com.tmnt.smartcontracts.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tmnt.smartcontracts.R;
import com.tmnt.smartcontracts.models.CropModel;

import java.util.List;

/**
 * Created by ajayrahul on 2/12/17.
 */

public class CropsListAdapter extends RecyclerView.Adapter<CropsListAdapter.ViewHolder> {

    private List<CropModel> cropModelList;
    CropModel tempValues;
    Context context;


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView code;
        Context context;

        public ViewHolder(View itemView, Context context) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.row_crops_title);
            code = (TextView) itemView.findViewById(R.id.row_crops_units);
            this.context = context;
        }
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);

    }

    @Override
    public int getItemCount() {
        if (cropModelList != null)
            return cropModelList.size();

        return 0;
    }


    public CropsListAdapter(Context context, List<CropModel> cropModelList) {
        this.cropModelList = cropModelList;
        this.context = context;
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_crops, parent, false);
        vh = new ViewHolder(v, context);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if (position < cropModelList.size()) {
            tempValues = cropModelList.get(position);

            holder.name.setText(tempValues.getName());
            holder.code.setText(tempValues.getUnits());

        } else {
            //It means the progress bar is shown on screen
        }
    }

}
