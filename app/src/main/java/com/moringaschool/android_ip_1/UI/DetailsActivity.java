package com.moringaschool.android_ip_1.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.android_ip_1.Constants;
import com.moringaschool.android_ip_1.Models.FilmEndPoint.Cast;
import com.moringaschool.android_ip_1.Models.FilmEndPoint.DetailApiResponse;
import com.moringaschool.android_ip_1.Network.OnDetailsApiListener;
import com.moringaschool.android_ip_1.Network.RequestManager;
import com.moringaschool.android_ip_1.R;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    private List<Cast> mCast;
    private Context mContext;

    private DetailApiResponse mResponse;

    RequestManager manager;
    ProgressDialog dialog; //android popup thingy

    @BindView (R.id.tvMovieName) TextView tvMovieName;
    @BindView (R.id.tvMovieReleaseYear) TextView tvMovieReleaseYear;
    @BindView (R.id.tvMovieRating) TextView tvMovieRating;
    @BindView (R.id.tvMovieDescription) TextView tvMovieDescription;
    @BindView (R.id.ivMoviePoster) ImageView ivMoviePoster;
    @BindView (R.id.tvMovieLength) TextView tvMovieLength;
    @BindView (R.id.btnWatchTrailer) Button btnWatchTrailer;
    @BindView (R.id.btnCast) Button btnCast;
    @BindView (R.id.btnAddToFavorites) Button btnAddToFavorites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        Toast.makeText(DetailsActivity.this, "You're going to have to be a little patient", Toast.LENGTH_SHORT).show();

        manager=new RequestManager(this); //Call the api

        String movie_id = getIntent().getStringExtra("movie_id"); //retrieve movie id from the MovieSearchActivity. NB. Call api after fetching movie_id.

        manager.searchMovieDetails(listener, movie_id); //use the received id

        dialog = new ProgressDialog(this);
        dialog.setTitle("I'm on it..."); //show this while loading. Be sure to dismiss() after.
        dialog.show();

    }

    private OnDetailsApiListener listener = new OnDetailsApiListener() {

        @Override
        public void onResponse(DetailApiResponse response) {

            dialog.dismiss();

            if(response.equals(null)){

                Toast.makeText(DetailsActivity.this, "You caught us. No data available.", Toast.LENGTH_SHORT).show();
                return; // to get out of this condition.
            }

            showResults(response);
        }

        @Override
        public void onError(String message) {

            dialog.dismiss();
            Toast.makeText(DetailsActivity.this, "An error occurred.", Toast.LENGTH_SHORT).show();

        }

    };

    private void showResults(DetailApiResponse response) { //map incoming data from api to elements.

        mCast=response.getCast();
        tvMovieName.setText(response.getTitle());
        tvMovieReleaseYear.setText("Year: "+response.getYear());
        tvMovieRating.setText("Rating: "+response.getRating());
        tvMovieLength.setText("Length: " +response.getLength());

        try {

            Picasso.get().load(response.getPoster()).into(ivMoviePoster); //Add try-catch for when the api does not return a valid poster url

        }catch (Exception e){

            Toast.makeText(DetailsActivity.this, "There appears to be no movie poster.", Toast.LENGTH_SHORT).show();

        }

        tvMovieDescription.setText(response.getPlot());

        btnWatchTrailer.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(response.getTrailer().getLink().toString()));
                startActivity(webIntent);

            }

        });

        btnCast.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent = new Intent(mContext, MovieCastActivity.class);
                intent.putExtra("cast", Parcels.wrap(mCast));
                mContext.startActivity(intent);

            }

        });

        btnAddToFavorites.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String uid = user.getUid();

                DatabaseReference databaseReference = FirebaseDatabase
                        .getInstance()
                        .getReference(Constants.FIREBASE_CHILD_MOVIES)  //node
                        .child(uid); //associate with this user

                DatabaseReference pushRef = databaseReference.push();

                String pushId = pushRef.getKey();

                mResponse.setPushId(pushId);

                pushRef.setValue(mResponse);

                Toast.makeText(DetailsActivity.this, "Added to favourites", Toast.LENGTH_SHORT).show();

            }

        });

    }

}