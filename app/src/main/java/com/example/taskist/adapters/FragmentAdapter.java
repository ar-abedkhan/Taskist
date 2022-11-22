package com.example.taskist.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.taskist.fragments.DoneFragment;
import com.example.taskist.fragments.EditFragment;
import com.example.taskist.fragments.HealthFragment;
import com.example.taskist.fragments.NotDoneFragment;
import com.example.taskist.fragments.OtherFragment;
import com.example.taskist.fragments.PersonalFragment;
import com.example.taskist.fragments.PinFragment;
import com.example.taskist.fragments.ShoppingFragment;
import com.example.taskist.fragments.ViewFragment;
import com.example.taskist.fragments.WorkFragment;

public class FragmentAdapter extends FragmentPagerAdapter {

    String[] name = {"Work", "Personal", "Shopping", "Health", "Other", "Done", "Not Done", "Pin"};

    public FragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){

            case 0:
                return new WorkFragment();
            case 1:
                return new PersonalFragment();
            case 2:
                return new ShoppingFragment();
            case 3:
                return new HealthFragment();
            case 4:
                return new OtherFragment();
            case 5:
                return new DoneFragment();
            case 6:
                return new NotDoneFragment();
            case 7:
                return new PinFragment();

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

