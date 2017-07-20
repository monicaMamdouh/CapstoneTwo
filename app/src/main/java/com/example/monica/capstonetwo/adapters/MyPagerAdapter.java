package com.example.monica.capstonetwo.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.monica.capstonetwo.fragments.FavouriteFragment;
import com.example.monica.capstonetwo.fragments.HomeFragment;

/**
 * Created by monica on 7/13/2017.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {

    private static final int NUMBERS=2;

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new HomeFragment();
            case 1:
                return new FavouriteFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount()
    {
        return NUMBERS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0:
                return "Home";
            case 1:
                return "Favourite";
            default:
                return null;
        }
    }

}
