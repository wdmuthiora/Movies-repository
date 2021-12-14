package com.moringaschool.android_ip_1.UI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moringaschool.android_ip_1.Models.FilmEndPoint.Cast;
import com.moringaschool.android_ip_1.Models.SearchEndPoint.SearchApiResponse;
import com.moringaschool.android_ip_1.R;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieCastFragment extends Fragment {

    @BindView(R.id.tvCharacter) TextView tvCharacter;
    @BindView(R.id.tvActor) TextView tvActor;

    private Cast mCast;

    public MovieCastFragment() {
    }

    public static MovieCastFragment newInstance(SearchApiResponse response) {

        MovieCastFragment movieCastFragment = new MovieCastFragment();
        Bundle args = new Bundle();
        args.putParcelable("response", Parcels.wrap(response));
        movieCastFragment.setArguments(args);
        return movieCastFragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mCast = Parcels.unwrap(getArguments().getParcelable("response"));
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_movie_cast, container, false);
        ButterKnife.bind(this,view);

        return view;

    }
}