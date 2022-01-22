package com.my.heakthapp.sliders;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.my.heakthapp.R;
import com.my.heakthapp.databinding.ImageSliderLayoutItemBinding;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterVH> {

    private Context context;
    private List<SliderItem> mSliderItems = new ArrayList<>();
    private ItemClick itemClick;

    public SliderAdapter(Context context, ItemClick itemClick) {
        this.context = context;
        this.itemClick = itemClick;
    }

    public void renewItems(List<SliderItem> sliderItems) {
        this.mSliderItems = sliderItems;
        notifyDataSetChanged();
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        ImageSliderLayoutItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.image_slider_layout_item, parent, false);
        return new SliderAdapterVH(binding);
    }


    @Override
    public void onBindViewHolder(SliderAdapterVH holder, int position) {

        SliderItem sliderItem = mSliderItems.get(position);

        holder.binding.tvAutoImageSlider.setText(sliderItem.getDescription());
        holder.binding.tvAutoImageSlider.setTextSize(16);
        holder.binding.tvAutoImageSlider.setTextColor(Color.WHITE);
        Glide.with(holder.itemView)
                .load(sliderItem.getImageUrl())
                .into(holder.binding.ivAutoImageSlider);
    }

    @Override
    public int getCount() {
        return mSliderItems.size();
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        ImageSliderLayoutItemBinding binding;

        public SliderAdapterVH(ImageSliderLayoutItemBinding layoutItemBinding) {
            super(layoutItemBinding.getRoot());
            this.binding = layoutItemBinding;
        }
    }
}
