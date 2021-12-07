package com.moringaschool.android_ip_1.Network;

import com.moringaschool.android_ip_1.Models.SearchEndPoint.SearchApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface GetMovies {
    //pass all the api headers here. Replace api key with Constants.IMDB_API
    @Headers({
            "Accept: application/json",
            "x-rapidapi-host:imdb-internet-movie-database-unofficial.p.rapidapi.com",
            "x-rapidapi-key:7701f21098msh24137e68c02d540p16282bjsn2f745c53ff8b"
    })

    //Endpoints.
    @GET("search/{movie_name}") //{movie_name} is a placeholder. the user supplies the query parameter
    Call<SearchApiResponse> callMovies(
            @Path("movie_name") String movie_name //Replace movie_name with the supplied movie_name in url
    );
}
