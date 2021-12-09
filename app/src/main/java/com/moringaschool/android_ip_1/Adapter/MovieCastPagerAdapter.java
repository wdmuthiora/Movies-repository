package com.moringaschool.android_ip_1.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.moringaschool.android_ip_1.Network.RequestManager;
import com.moringaschool.android_ip_1.UI.MovieCastFragment;

public class MovieCastPagerAdapter extends FragmentPagerAdapter {

    RequestManager manager;

    public MovieCastPagerAdapter(@NonNull FragmentManager fm, int behavior, RequestManager manager) {
        super(fm, behavior);
        this.manager = manager;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
//        MovieCastFragment.newInstance(manager.searchMovies().get(position));
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
