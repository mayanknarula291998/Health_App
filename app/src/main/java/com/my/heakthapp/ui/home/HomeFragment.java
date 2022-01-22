package com.my.heakthapp.ui.home;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.my.heakthapp.R;
import com.my.heakthapp.model.CategoryModel;
import com.my.heakthapp.adapter.CategoryAdapter;
import com.my.heakthapp.adapter.ModelDataAdapter;
import com.my.heakthapp.databinding.FragmentHomeTwoBinding;
import com.my.heakthapp.sliders.ItemClick;
import com.my.heakthapp.sliders.SliderAdapter;
import com.my.heakthapp.sliders.SliderItem;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements ItemClick {


    private FragmentHomeTwoBinding binding;
    HomeViewModel viewModel;

    List<CategoryModel> categoryModels = new ArrayList<>();
    List<CategoryModel> modelList = new ArrayList<>();
    private SliderAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeTwoBinding.inflate(inflater, container, false);
        getImages();
        getData();

        return binding.getRoot();
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void getImages() {
        adapter = new SliderAdapter(requireContext(), HomeFragment.this::onClick);

        binding.sliderView.setSliderAdapter(adapter);
        binding.sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        binding.sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        binding.sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        binding.sliderView.setIndicatorSelectedColor(Color.WHITE);
        binding.sliderView.setIndicatorUnselectedColor(Color.GRAY);
        binding.sliderView.setScrollTimeInSec(3);
        binding.sliderView.setAutoCycle(true);
        binding.sliderView.startAutoCycle();

        List<SliderItem> sliderItemList = new ArrayList<>();
        sliderItemList.add(new SliderItem("One", requireContext().getDrawable(R.drawable.ic_doctor_60)));
        sliderItemList.add(new SliderItem("One", requireContext().getDrawable(R.drawable.ic_ambulance_60)));
        sliderItemList.add(new SliderItem("One", requireContext().getDrawable(R.drawable.ic_hospital_60)));
        sliderItemList.add(new SliderItem("One", requireContext().getDrawable(R.drawable.medical)));
        sliderItemList.add(new SliderItem("One", requireContext().getDrawable(R.drawable.ic_oxygen_60)));

        adapter.renewItems(sliderItemList);
    }

    private void getData() {
        viewModel.getCategories().observe(requireActivity(), new Observer<List<CategoryModel>>() {
            @Override
            public void onChanged(List<CategoryModel> categoryModels) {
                if (categoryModels.size() > 0) {
                    binding.category.setAdapter(new CategoryAdapter(categoryModels, getActivity(), HomeFragment.this::onClick));
                    binding.category.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
                }
            }
        });

        viewModel.getFreshRecommendations().observe(requireActivity(), new Observer<List<Integer>>() {
            @Override
            public void onChanged(List<Integer> integers) {
                if (integers.size() > 0) {
                    binding.freshRecommendations.setAdapter(new ModelDataAdapter(integers, getActivity(), HomeFragment.this::onClick));
                    binding.freshRecommendations.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                }
            }
        });

        viewModel.getTopDoctors().observe(requireActivity(), new Observer<List<Integer>>() {
            @Override
            public void onChanged(List<Integer> integers) {
                if (integers.size() > 0) {
                    binding.topDoctors.setAdapter(new ModelDataAdapter(integers, getActivity(), HomeFragment.this::onClick));
                    binding.topDoctors.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                }
            }
        });

        viewModel.getTopHospitals().observe(requireActivity(), new Observer<List<Integer>>() {
            @Override
            public void onChanged(List<Integer> integers) {
                if (integers.size() > 0) {
                    binding.topHospitals.setAdapter(new ModelDataAdapter(integers, getActivity(), HomeFragment.this::onClick));
                    binding.topHospitals.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                }
            }
        });
    }

    @Override
    public void onClick(int position, String type) {

    }
}