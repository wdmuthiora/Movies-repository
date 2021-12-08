package com.moringaschool.android_ip_1.UI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moringaschool.android_ip_1.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieCastFragment extends Fragment {
    @BindView(R.id.rvCastList) RecyclerView rvCastList;

    public MovieCastFragment() {
        // Required empty public constructor
    }

    public static MovieCastFragment newInstance(String param1, String param2) {

        MovieCastFragment fragment = new MovieCastFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_movie_cast, container, false);
        ButterKnife.bind(this,view);

        return view;

    }
}