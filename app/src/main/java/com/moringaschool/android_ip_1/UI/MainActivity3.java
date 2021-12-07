package com.moringaschool.android_ip_1.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.moringaschool.android_ip_1.Adapter.HomeRecyclerAdapter;
import com.moringaschool.android_ip_1.Models.SearchEndPoint.SearchApiResponse;
import com.moringaschool.android_ip_1.Network.OnSearchApiListener;
import com.moringaschool.android_ip_1.Network.RequestManager;
import com.moringaschool.android_ip_1.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity3 extends AppCompatActivity implements OnMovieClickListener {

    @BindView(R.id.svSearchView) SearchView svSearchView;
    @BindView(R.id.rvRecyclerView) RecyclerView rvRecyclerView;

    HomeRecyclerAdapter adapter;

    RequestManager manager;

    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ButterKnife.bind(this);

        dialog=new ProgressDialog(this);

        manager=new RequestManager(this); //Network

        svSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {  //set listener to the search field.
            @Override
            public boolean onQueryTextSubmit(String query) {
                dialog.setTitle("Please wait.."); //show this while waiting. Be sure to dismiss() after
                dialog.show();
                manager.searchMovies(listener,query);  //call api, and search for this "query"
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }

        });

    }

    private final OnSearchApiListener listener=new OnSearchApiListener() {

        @Override
        public void onResponse(SearchApiResponse response) {

            dialog.dismiss();

            if(response==null){
                Toast.makeText(MainActivity3.this, "No data available", Toast.LENGTH_SHORT).show();
                return; //to get out of this.
            }
            showResult(response);
        }

        @Override
        public void onError(String message) {
            dialog.dismiss();
            Toast.makeText(MainActivity3.this, "An error occurred", Toast.LENGTH_SHORT).show();
        }

    };

    private void showResult(SearchApiResponse response) {

        rvRecyclerView.setHasFixedSize(true);
        rvRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity3.this, 1)); //show 3 items per row
        adapter=new HomeRecyclerAdapter(this, response.getTitles(), this);
        rvRecyclerView.setAdapter(adapter);
        
    }

    @Override
    public void onMovieClicked(String id) {

        startActivity(new Intent(MainActivity3.this, DetailsActivity.class).putExtra("movie_id", id)); //pass id to the DetailsActivity

    }

}