package com.example.taskist.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.taskist.fragments.EditFragment;
import com.example.taskist.fragments.ViewFragment;

public class FragmenteditviewAdapter extends FragmentPagerAdapter {

    String[] editview = {"View", "Edit"};

    public FragmenteditviewAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ViewFragment();
            case 1:
                return new EditFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return editview.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return editview[position];
    }
}
