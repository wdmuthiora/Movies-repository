package com.moringaschool.android_ip_1.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.moringaschool.android_ip_1.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    @BindView (R.id.tvMovieName) TextView tvMovieName;
    @BindView (R.id.tvMovieReleaseYear) TextView tvMovieReleaseYear;
    @BindView (R.id.tvMovieRating) TextView tvMovieRating;
    @BindView (R.id.tvMovieDescription) TextView tvMovieDescription;
    @BindView(R.id.ivMoviePoster) ImageView ivMoviePoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ButterKnife.bind(this);
    }
}