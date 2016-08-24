package com.tuananhse.fragment.fragment_movie.api;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tuananhse.adapter.MovieAdapter;
import com.tuananhse.examplematerialretrofitmvp.R;
import com.tuananhse.fragment.fragment_movie.api.presenter.MainPresenter;
import com.tuananhse.model.Movie;
import com.tuananhse.view.FragmentDrawer;
import com.tuananhse.view.MainActivity;

import java.util.ArrayList;

/**
 * Created by kyubj on 8/24/2016.
 */
public class fragment_movie extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager reLayoutManager;
    private MainPresenter mainPresenter;
    private Context context;
    // private MovieAdapter mainMovieAdapter;


    public static MovieAdapter mainMovieAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    //các sự kiện xảy ra trong fragment_movie
       View view=inflater.inflate(R.layout.fragment_movie,null);
        Toast.makeText(getContext(),"Đang mở tui",Toast.LENGTH_LONG).show();
        mainPresenter=new MainPresenter(context);
        recyclerView= (RecyclerView)view.findViewById(R.id.recymovie1);
        reLayoutManager=new LinearLayoutManager(context);
        mainMovieAdapter=new MovieAdapter(context,new ArrayList<Movie>());
        recyclerView.setLayoutManager(reLayoutManager);
        recyclerView.setAdapter(mainMovieAdapter);
        mainPresenter.fetchData();
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
