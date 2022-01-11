package com.moringaschool.android_ip_1.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.android_ip_1.Adapter.HomeRecyclerAdapter;
import com.moringaschool.android_ip_1.Constants;
import com.moringaschool.android_ip_1.Models.SearchEndPoint.SearchApiResponse;
import com.moringaschool.android_ip_1.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavouriteMoviesActivity extends AppCompatActivity {

    private DatabaseReference databaseReference;

    //Needs adapter.

    @BindView(R.id.tvProfileGreeting) TextView tvProfileGreeting;
    @BindView(R.id.svSearchView) SearchView svSearchView;
    @BindView(R.id.rvRecyclerView) RecyclerView rvRecyclerView;
    @BindView(R.id.cvResultsDisplay) CardView cvResultsDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_search); //Reuse another Activity's default view
        ButterKnife.bind(this);

        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        String uid = firebaseUser.getUid();

        databaseReference = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_MOVIES)
                .child(uid);

    }

    private void showResult(SearchApiResponse response) {

        rvRecyclerView.setHasFixedSize(true); //Do not adapt size to accommodate different size results
        rvRecyclerView.setLayoutManager(new GridLayoutManager(FavouriteMoviesActivity.this, 1)); //show 3 items per row
        //adapter=new HomeRecyclerAdapter(this, response.getTitles(), this);
      //  rvRecyclerView.setAdapter(adapter);

    }

}