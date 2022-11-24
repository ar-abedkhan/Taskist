package com.example.taskist.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.taskist.fragments.HealthFragment;
import com.example.taskist.fragments.OtherFragment;
import com.example.taskist.fragments.PersonalFragment;
import com.example.taskist.fragments.ShoppingFragment;
import com.example.taskist.fragments.WorkFragment;

public class CetagoryAdapter extends FragmentPagerAdapter {
    String [] cetagorynamr ={"Health","Shopping","Work","Personal","Others"};
    public CetagoryAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HealthFragment();
            case 1:
                return new ShoppingFragment();
            case 2:
                return new WorkFragment();
            case 3:
                return new PersonalFragment();
            case 4:
                return new OtherFragment();

        }
        return null;
    }

    @Override
    public int getCount() {
        return cetagorynamr.length;

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return cetagorynamr[position];
    }
}
