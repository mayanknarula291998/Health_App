package com.my.heakthapp.model;

public class CategoryModel {

    String name;
    int img;

    public CategoryModel(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }
}
