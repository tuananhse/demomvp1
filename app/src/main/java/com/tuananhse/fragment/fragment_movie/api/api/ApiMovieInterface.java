package com.tuananhse.fragment.fragment_movie.api.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by kyubj on 8/22/2016.
 */
public interface ApiMovieInterface {
    @GET("movie/popular?api_key=6afa07690e0b1a36eadd31f51e90e3a0")
    Call<ResponseBody> popular();

    @GET("movie/top_rated?api_key=6afa07690e0b1a36eadd31f51e90e3a0")
    Call<ResponseBody> topRated();

   /* @POST("toprated")
    Call<ResponseBody> ggset(@Body RequestBody body);*/
}
