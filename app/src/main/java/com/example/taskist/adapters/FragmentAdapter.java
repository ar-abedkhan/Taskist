package com.example.taskist.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.taskist.fragments.CetagoryFragment;
import com.example.taskist.fragments.DoneFragment;
import com.example.taskist.fragments.EditFragment;
import com.example.taskist.fragments.FavouriteFragment;
import com.example.taskist.fragments.HealthFragment;
import com.example.taskist.fragments.NotDoneFragment;
import com.example.taskist.fragments.OtherFragment;
import com.example.taskist.fragments.PersonalFragment;
import com.example.taskist.fragments.PinFragment;
import com.example.taskist.fragments.ShoppingFragment;
import com.example.taskist.fragments.StatusFragment;
import com.example.taskist.fragments.ViewFragment;
import com.example.taskist.fragments.WorkFragment;

public class FragmentAdapter extends FragmentPagerAdapter {

    String[] name = {"Category","Status","Favourite"};

    public FragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){

            case 0:
                return new CetagoryFragment();
            case 1:
                return new StatusFragment();
            case 2:
                return new FavouriteFragment();

        }

        return null;
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return name[position];
    }

}

