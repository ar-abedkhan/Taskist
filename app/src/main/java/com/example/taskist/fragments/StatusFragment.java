package com.example.taskist.fragments;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taskist.R;
import com.example.taskist.adapters.AllTaskFragmentAdapter;
import com.example.taskist.adapters.FragmenteditviewAdapter;
import com.example.taskist.adapters.StatusAdapter;
import com.example.taskist.databinding.FragmentStatusBinding;
public class StatusFragment extends Fragment {

    public StatusFragment() {

    }
private FragmentStatusBinding binding;
    FragmentManager fragmentManager;
    StatusAdapter statusAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding=FragmentStatusBinding.inflate(getLayoutInflater(),container,false);


        fragmentManager=getChildFragmentManager();
        statusAdapter = new StatusAdapter(fragmentManager,100);
        binding.statusviewPager.setAdapter(statusAdapter);
        binding.statustablayout.setupWithViewPager(binding.statusviewPager);





        return binding.getRoot();

    }
}