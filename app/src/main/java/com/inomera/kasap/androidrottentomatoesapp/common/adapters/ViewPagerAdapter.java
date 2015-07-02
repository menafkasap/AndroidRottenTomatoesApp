package com.inomera.kasap.androidrottentomatoesapp.common.adapters;
/**
 * Created by Sorry on 17.06.2015.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.inomera.kasap.androidrottentomatoesapp.common.fragments.BoxOfficeFragment;
import com.inomera.kasap.androidrottentomatoesapp.common.fragments.InTheatersFragment;
import com.inomera.kasap.androidrottentomatoesapp.common.fragments.OpeningFragment;
import com.inomera.kasap.androidrottentomatoesapp.common.fragments.UpcomingFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence Titles[]; // This will Store the titles of the Tabs which are Going to be passed when com.inomera.kasap.androidrottentomatoesapp.common.adapters.ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the com.inomera.kasap.androidrottentomatoesapp.common.adapters.ViewPagerAdapter is created

    // Build a Constructor and assign the passed Values to appropriate values in the class
    public ViewPagerAdapter(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;
    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {

        // if the position is 0 we are returning the box office tab
        if (position == 0) {
            return new BoxOfficeFragment();
        } else if (position == 1) // if the position is 0 we are returning the upcoming tab
        {
            return new UpcomingFragment();
        } else if (position == 2) // if the position is 0 we are returning the in theaters tab
        {
            return new InTheatersFragment();
        } else             // As we are having 4 tabs it must be opening so we are returning opening tab
        {
            return new OpeningFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}