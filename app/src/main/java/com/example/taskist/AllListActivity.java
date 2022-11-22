package com.example.taskist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.taskist.adapters.FragmentAdapter;
import com.example.taskist.databinding.ActivityAllListBinding;

public class AllListActivity extends AppCompatActivity {

    ActivityAllListBinding binding;
    FragmentManager fragmentManager;
    FragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAllListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fragmentManager = getSupportFragmentManager();
        adapter = new FragmentAdapter(fragmentManager,100);
        binding.viewPager.setAdapter(adapter);
        binding.tablayout.setupWithViewPager(binding.viewPager);

        binding.tablayout.getTabAt(0).setIcon(R.drawable.work);
        binding.tablayout.getTabAt(1).setIcon(R.drawable.personal);
        binding.tablayout.getTabAt(2).setIcon(R.drawable.shopping);
        binding.tablayout.getTabAt(2).setText("Shopping");
        binding.tablayout.getTabAt(3).setIcon(R.drawable.health);
        binding.tablayout.getTabAt(4).setIcon(R.drawable.others);
        binding.tablayout.getTabAt(5).setIcon(R.drawable.done);
        binding.tablayout.getTabAt(6).setIcon(R.drawable.notdone);
        binding.tablayout.getTabAt(7).setIcon(R.drawable.pin);

        binding.backBtn.setOnClickListener(view -> {
            startActivity(new Intent(AllListActivity.this, MainToDoActivity.class));
            finish();
        });


    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(AllListActivity.this,MainToDoActivity.class));
        super.onBackPressed();
    }
}