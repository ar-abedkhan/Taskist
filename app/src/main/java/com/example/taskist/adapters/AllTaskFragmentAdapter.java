package com.example.taskist.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.taskist.fragments.CetagoryFragment;
import com.example.taskist.fragments.FavouriteFragment;
import com.example.taskist.fragments.StatusFragment;

import java.util.List;

public class AllTaskFragmentAdapter extends FragmentPagerAdapter {
    String [] alltask ={"Status","Category","Favourite"};
    public AllTaskFragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new StatusFragment();
            case 1:
                return new CetagoryFragment();
            case 2:
                return new FavouriteFragment();

        }
        return null;
    }

    @Override
    public int getCount() {
        return alltask.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return alltask[position];
    }
}
