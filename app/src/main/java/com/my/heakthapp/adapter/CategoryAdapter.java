package com.my.heakthapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.my.heakthapp.R;
import com.my.heakthapp.databinding.CatItemBinding;
import com.my.heakthapp.model.CategoryModel;
import com.my.heakthapp.sliders.ItemClick;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    List<CategoryModel> dataList;
    Context context;
    ItemClick itemClick;


    public CategoryAdapter(List<CategoryModel> dataList, Context context, ItemClick itemClick) {
        this.dataList = dataList;
        this.context = context;
        this.itemClick = itemClick;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CatItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.cat_item, parent, false);
        return new ViewHolder(binding);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CategoryModel myData = dataList.get(position);

        Glide.with(context).load(myData.getImg()).into(holder.binding.imageView);
        holder.binding.textView.setText(myData.getName());
        holder.binding.parent.setOnClickListener(v -> {
            itemClick.onClick(position, "cat");
        });
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        CatItemBinding binding;

        public ViewHolder(CatItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }
}