package com.example.taskist.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taskist.R;
import com.example.taskist.adapters.CetagoryAdapter;
import com.example.taskist.databinding.FragmentCetagoryBinding;

public class CetagoryFragment extends Fragment {


    public CetagoryFragment() {
    }
private FragmentCetagoryBinding binding;
    FragmentManager fragmentManager;
    CetagoryAdapter cetagoryAdapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
                binding=FragmentCetagoryBinding.inflate(getLayoutInflater(),container,false);


                fragmentManager=getChildFragmentManager();
                cetagoryAdapter= new CetagoryAdapter(fragmentManager,100);
                binding.cetagoryViewpager.setAdapter(cetagoryAdapter);
                binding.cetagoryTabLayout.setupWithViewPager(binding.cetagoryViewpager);


//        binding.cetagoryTabLayout.getTabAt(0).setIcon(R.drawable.health2);
//        binding.cetagoryTabLayout.getTabAt(1).setIcon(R.drawable.shopping);
//        binding.cetagoryTabLayout.getTabAt(2).setIcon(R.drawable.work);
//        binding.cetagoryTabLayout.getTabAt(3).setIcon(R.drawable.personal);
//        binding.cetagoryTabLayout.getTabAt(4).setIcon(R.drawable.ic_baseline_more_24);



        return binding.getRoot();
    }
}