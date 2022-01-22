package com.my.heakthapp.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.my.heakthapp.model.CategoryModel;
import com.my.heakthapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomeViewModel extends AndroidViewModel {

    private final MutableLiveData<List<CategoryModel>> categoryLiveData;
    private final List<CategoryModel> categoryModels = new ArrayList<>();
    private final List<Integer> modelListOne = new ArrayList<>();
    private final List<Integer> modelListTwo = new ArrayList<>();
    private final List<Integer> modelListThree = new ArrayList<>();
    private final MutableLiveData<List<Integer>> liveData;


    public HomeViewModel(@NonNull Application application) {
        super(application);
        categoryLiveData = new MutableLiveData<>();
        liveData = new MutableLiveData<>();
    }

    public LiveData<List<CategoryModel>> getCategories() {
        categoryModels.add(new CategoryModel("Doctor", R.drawable.ic_doctor_60));
        categoryModels.add(new CategoryModel("Hospital", R.drawable.ic_hospital_60));
        categoryModels.add(new CategoryModel("Medical", R.drawable.ic_medical_60));
        categoryModels.add(new CategoryModel("Ambulance", R.drawable.ic_ambulance_60));
        categoryModels.add(new CategoryModel("Oxygen", R.drawable.ic_oxygen_60));

        categoryLiveData.setValue(categoryModels);
        return categoryLiveData;
    }

    public LiveData<List<Integer>> getFreshRecommendations() {
        modelListOne.clear();
        modelListOne.add(0);
        modelListOne.add(1);
        modelListOne.add(2);
        modelListOne.add(3);
        modelListOne.add(4);
        modelListOne.add(1);
        modelListOne.add(3);

        liveData.setValue(modelListOne);
        return liveData;
    }

    public LiveData<List<Integer>> getTopDoctors() {
        modelListTwo.add(0);
        modelListTwo.add(0);
        modelListTwo.add(0);
        modelListTwo.add(0);
        modelListTwo.add(0);
        modelListTwo.add(0);
        modelListTwo.add(0);

        liveData.setValue(modelListTwo);
        return liveData;
    }
    public LiveData<List<Integer>> getTopHospitals() {
        modelListThree.add(1);
        modelListThree.add(1);
        modelListThree.add(1);
        modelListThree.add(1);
        modelListThree.add(1);
        modelListThree.add(1);
        modelListThree.add(1);

        liveData.setValue(modelListThree);
        return liveData;
    }

}
