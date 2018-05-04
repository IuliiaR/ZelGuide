package com.example.android.zelguide;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class CategoryAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new SightsFragment();
        } else if (position == 1) {
            return new EntertainmentFragment();
        } else if (position == 2) {
            return new RestaurantsFragment();
        } else return new HotelsFragment();
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        int titleResourceId;
        switch (position) {
            case 0:
                titleResourceId = R.string.tab_title_sight;
                break;
            case 1:
                titleResourceId = R.string.tab_title_entertainment;
                break;
            case 2:
                titleResourceId = R.string.tab_title_restaurant;
                break;
            case 3:
                titleResourceId = R.string.tab_title_hotel;
                break;
            default:
                titleResourceId = R.string.tab_title_sight;
                break;
        }
        return mContext.getString(titleResourceId);
    }
}
