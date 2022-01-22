package com.my.heakthapp.sliders;

import android.graphics.drawable.Drawable;

public class SliderItem {
    private String description;
    private Drawable imageUrl;

    public String getDescription() {
        return description;
    }
    public Drawable getImageUrl() {
        return imageUrl;
    }

    public SliderItem(String description, Drawable imageUrl) {
        this.description = description;
        this.imageUrl = imageUrl;
    }
}
