package com.my.heakthapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.my.heakthapp.R;
import com.my.heakthapp.sliders.ItemClick;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ModelDataAdapter extends RecyclerView.Adapter<ModelDataAdapter.ViewHolder> {

    List<Integer> dataList;
    Context context;
    ItemClick itemClick;
    private static final int DOCTOR = 0, HOSPITAL = 1, MEDICAL = 2, AMBULANCE = 3, OXYGEN = 4;

    public ModelDataAdapter(List<Integer> dataList, Context context, ItemClick itemClick) {
        this.dataList = dataList;
        this.context = context;
        this.itemClick = itemClick;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if ((viewType == DOCTOR) || (viewType == HOSPITAL)) {

            View view = LayoutInflater.from(context).inflate(R.layout.list_model_data, parent, false);
            return new ModelDataAdapter.ViewHolder(view, viewType);

        } else if (viewType == MEDICAL) {

            View view = LayoutInflater.from(context).inflate(R.layout.list_medical_data, parent, false);
            return new ModelDataAdapter.ViewHolder(view, viewType);

        } else if (viewType == AMBULANCE) {

            View view = LayoutInflater.from(context).inflate(R.layout.list_ambulance, parent, false);
            return new ModelDataAdapter.ViewHolder(view, viewType);

        } else {

            View view = LayoutInflater.from(context).inflate(R.layout.list_oxygen, parent, false);
            return new ModelDataAdapter.ViewHolder(view, viewType);

        }

    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (holder.Type == DOCTOR) {
            Glide.with(context).load(context.getDrawable(R.drawable.ic_doctor_60)).into(holder.imageView);
        } else if (holder.Type == HOSPITAL) {
            Glide.with(context).load(context.getDrawable(R.drawable.ic_hospital_60)).into(holder.imageView);
        } else if (holder.Type == MEDICAL) {
            Glide.with(context).load(context.getDrawable(R.drawable.ic_medical_60)).into(holder.imageView);
        } else if (holder.Type == AMBULANCE) {
            Glide.with(context).load(context.getDrawable(R.drawable.ic_ambulance_60)).into(holder.imageView);
        } else {
            Glide.with(context).load(context.getDrawable(R.drawable.ic_oxygen_60)).into(holder.imageView);
        }

    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        ImageView imageView;
        int Type;
        RelativeLayout layout;

        public ViewHolder(View itemView, int viewType) {
            super(itemView);
            this.Type = viewType;
            this.imageView = itemView.findViewById(R.id.imageView2);


            if ((Type == DOCTOR) || (Type == HOSPITAL)) {

                this.name = itemView.findViewById(R.id.name);

            } else if (Type == MEDICAL) {
                this.name = itemView.findViewById(R.id.textView2);
            } else if (Type == AMBULANCE) {


            } else {


            }
            //end
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (dataList.get(position) == 0) {
            return DOCTOR;
        } else if (dataList.get(position) == 1) {
            return HOSPITAL;
        } else if (dataList.get(position) == 2) {
            return MEDICAL;
        } else if (dataList.get(position) == 3) {
            return AMBULANCE;
        } else {
            return OXYGEN;
        }
    }
}