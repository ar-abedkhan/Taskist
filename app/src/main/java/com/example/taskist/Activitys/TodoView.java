package com.example.taskist.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.taskist.R;
import com.example.taskist.adapters.FragmenteditviewAdapter;
import com.example.taskist.databinding.ActivityTodoViewBinding;

public class TodoView extends AppCompatActivity {
FragmentManager fragmentManager;
FragmenteditviewAdapter fragmentAdapter;
ActivityTodoViewBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityTodoViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    fragmentManager=getSupportFragmentManager();
    fragmentAdapter=new FragmenteditviewAdapter(fragmentManager,101);
    binding.viewpager.setAdapter(fragmentAdapter);

    binding.tablayout.setupWithViewPager(binding.viewpager);

    binding.tablayout.getTabAt(0).setIcon(R.drawable.checklist);
    binding.tablayout.getTabAt(1).setIcon(R.drawable.edit);


    }
}