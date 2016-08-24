package com.tuananhse.fragment.fragment_movie.api.presenter;

import android.content.Context;

import com.tuananhse.fragment.fragment_movie.api.api.ApiMovie;
import com.tuananhse.fragment.fragment_movie.api.fragment_movie;
import com.tuananhse.view.MainActivity;

import org.json.JSONArray;

/**
 * Created by kyubj on 8/23/2016.
 */
public class MainPresenter {
    ApiMovie apiMovie;
    Context context;
    /*ArrayList<Movie> data;
   MovieAdapter a;*/
    public MainPresenter(Context c) {
        this.context = c;
        apiMovie=ApiMovie.getInstance();
       // data = new ArrayList<>();
       // a = new MovieAdapter(c,data);



    }

   /* public MovieAdapter getA() {
        return a;
    }

    public void setA(MovieAdapter a) {
        this.a = a;
    }*/

    public void fetchData() {
        apiMovie.fetchPopular(new FetchDataCallback() {
            @Override
            public void onFetchSuccess(JSONArray data) {
                //getParent().
                fragment_movie.mainMovieAdapter.setData(data);
                //getParent().mainMovieAdapter.setData(data);
            }

            @Override
            public void onFetchFault(Exception e) {
                e.printStackTrace();
            }
        });
    }

    private MainActivity getParent() {
        return (MainActivity) this.context;
    }




}
