package com.moringaschool.android_ip_1.Network;

import android.content.Context;
import android.provider.ContactsContract;
import android.widget.Toast;

import com.moringaschool.android_ip_1.Constants;
import com.moringaschool.android_ip_1.Models.SearchEndPoint.SearchApiResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestManager{
    Context context;
    Retrofit retrofit= new Retrofit.Builder().baseUrl(Constants.IMDB_BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

    public RequestManager(Context context) {
        this.context = context;
    }

    public void searchMovies(OnSearchApiListener listener, String movie_name){
        GetMovies getMovies=retrofit.create(GetMovies.class);
        Call<SearchApiResponse> call = getMovies.callMovies(movie_name);

        call.enqueue(new Callback<SearchApiResponse>() {
            @Override
            public void onResponse(Call<SearchApiResponse> call, Response<SearchApiResponse> response) {
               if(!response.isSuccessful()){
                   Toast.makeText(context, "Something went wrong. Please check you connection and try again.", Toast.LENGTH_SHORT).show();
               }
               listener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<SearchApiResponse> call, Throwable t) {
                listener.onError(t.getMessage()); //get message from throwable.
            }
        });
    }


}
