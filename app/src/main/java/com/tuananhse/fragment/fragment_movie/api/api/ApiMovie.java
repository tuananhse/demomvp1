package com.tuananhse.fragment.fragment_movie.api.api;

import com.tuananhse.fragment.fragment_movie.api.presenter.FetchDataCallback;
import com.tuananhse.fragment.fragment_movie.api.presenter.FetchDataInterface;
import com.tuananhse.model.Movie;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by kyubj on 8/22/2016.
 */
public class ApiMovie implements FetchDataInterface {
    public static ApiMovie instance;
    public static ApiMovie getInstance()
    {
        if(instance==null)
        {
            return new ApiMovie();
        }
        else
        {
            return instance;
        }
    }
    //private static final String URL="http://api.themoviedb.org/3/";
    private static Retrofit retrofit;
    private ApiMovieInterface apiInterface;
    public ApiMovie() {
        retrofit=new Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/").build();
        apiInterface=retrofit.create(ApiMovieInterface.class);
    }
    public void fetchPopular(final FetchDataCallback callback)
    {
        Call<ResponseBody> ret=apiInterface.popular();
        ret.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    JSONObject jsonObject=new JSONObject(response.body().string());
                    JSONArray jsonArray=jsonObject.getJSONArray("results");
                   ArrayList<Movie> data1=Movie.getMovieData(jsonArray);
                  callback.onFetchSuccess(jsonArray);
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    callback.onFetchFault(e);
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public void fetchTopRated(final FetchDataCallback callback)
    {
        Call<ResponseBody> ret = apiInterface.topRated();
        ret.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.body().string());
                    JSONArray jsonArray = jsonObject.getJSONArray("results");
                    callback.onFetchSuccess(jsonArray);
                } catch (Exception e){
                    callback.onFetchFault(e);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callback.onFetchFault(new Exception(t));
            }
        });
    }


}
