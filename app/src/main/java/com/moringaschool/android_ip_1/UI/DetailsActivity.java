package com.moringaschool.android_ip_1.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.moringaschool.android_ip_1.Models.FilmEndPoint.DetailApiResponse;
import com.moringaschool.android_ip_1.Network.OnDetailsApiListener;
import com.moringaschool.android_ip_1.Network.RequestManager;
import com.moringaschool.android_ip_1.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    RequestManager manager;
    ProgressDialog dialog;

    @BindView (R.id.tvMovieName) TextView tvMovieName;
    @BindView (R.id.tvMovieReleaseYear) TextView tvMovieReleaseYear;
    @BindView (R.id.tvMovieRating) TextView tvMovieRating;
    @BindView (R.id.tvMovieDescription) TextView tvMovieDescription;
    @BindView(R.id.ivMoviePoster) ImageView ivMoviePoster;
    @BindView(R.id.tvMovieLength) TextView tvMovieLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ButterKnife.bind(this);

        manager=new RequestManager(this);

        String movie_id = getIntent().getStringExtra("movie_id"); //retrieve movie id from the MainActivity3. NB. Call api after fetching movie_id.

        manager.searchMovieDetails(listener, movie_id); //use the received id

        dialog = new ProgressDialog(this);
        dialog.setTitle("Please wait."); //show this while loading. Be sure to dismiss() after.
        dialog.show();

    }

    private OnDetailsApiListener listener = new OnDetailsApiListener() {
        @Override
        public void onResponse(DetailApiResponse response) {
            dialog.dismiss();
            if(response.equals(null)){

                Toast.makeText(DetailsActivity.this, "Could not retrieve data. Try again", Toast.LENGTH_SHORT).show();
                return; // to get out of this condition.
            }

            showResults(response);
        }

        @Override
        public void onError(String message) {
            dialog.dismiss();
            Toast.makeText(DetailsActivity.this, "Error.", Toast.LENGTH_SHORT).show();
        }

    };

    private void showResults(DetailApiResponse response) { //map incoming data from api to elements.

        tvMovieName.setText(response.getTitle());
        tvMovieReleaseYear.setText("Year"+response.getYear());
        tvMovieRating.setText("Rating: "+response.getRating());
        tvMovieLength.setText("Length: " +response.getLength());
        Picasso.get().load(response.getPoster()).into(ivMoviePoster); //Add try-catch for when the api does not return a valid poster url
        tvMovieDescription.setText(response.getPlot());

    }

}