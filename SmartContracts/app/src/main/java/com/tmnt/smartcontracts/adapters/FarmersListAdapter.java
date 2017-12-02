package com.tmnt.smartcontracts.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tmnt.smartcontracts.R;
import com.tmnt.smartcontracts.models.FarmerModel;

import java.util.List;

/**
 * Created by ajayrahul on 2/12/17.
 */

public class FarmersListAdapter extends RecyclerView.Adapter<FarmersListAdapter.ViewHolder> {
    private List<FarmerModel> farmerModelList;
    FarmerModel tempValues;
    Context context;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        public void onItemClick(FarmerModel farmerModel);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        Context context;

        public ViewHolder(View itemView, Context context) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.row_farmers_title);
            this.context = context;
        }
    }


    @Override
    public void onBindViewHolder(FarmersListAdapter.ViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);

    }

    @Override
    public int getItemCount() {
        if (farmerModelList != null)
            return farmerModelList.size();

        return 0;
    }


    public FarmersListAdapter(Context context, List<FarmerModel> farmerModelList,OnItemClickListener listener ) {
        this.farmerModelList = farmerModelList ;
        this.context = context;
        this.listener = listener;
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        FarmersListAdapter.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_farmers_list, parent, false);
        vh = new ViewHolder(v, context);
        return vh;
    }

    @Override
    public void onBindViewHolder(FarmersListAdapter.ViewHolder holder, final int position) {

        if (position < farmerModelList.size()) {
            tempValues = farmerModelList.get(position);

            holder.name.setText(tempValues.getName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(farmerModelList.get(position));
                }
            });


        } else {
            //It means the progress bar is shown on screen
        }
    }


}
