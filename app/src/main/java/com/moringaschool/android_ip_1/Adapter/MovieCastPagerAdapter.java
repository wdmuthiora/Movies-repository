package com.moringaschool.android_ip_1.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.moringaschool.android_ip_1.Models.FilmEndPoint.Cast;
import com.moringaschool.android_ip_1.Network.RequestManager;
import com.moringaschool.android_ip_1.UI.MovieCastFragment;

import java.util.List;

public class MovieCastPagerAdapter extends FragmentPagerAdapter {

    private List<Cast> mCast;

    RequestManager manager;

    public MovieCastPagerAdapter(@NonNull FragmentManager fm, int behavior, List<Cast> mCast) {
        super(fm, behavior);
        this.mCast = mCast;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
