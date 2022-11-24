package com.example.taskist.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.taskist.fragments.DoneFragment;
import com.example.taskist.fragments.NotDoneFragment;

public class StatusAdapter extends FragmentPagerAdapter {
    String [] status ={"Done","UnDone"};

    public StatusAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new DoneFragment();
            case 1:
                return new NotDoneFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return status.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return status[position];
    }
}
