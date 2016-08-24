package com.tuananhse.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.tuananhse.adapter.MovieAdapter;
import com.tuananhse.examplematerialretrofitmvp.R;
import com.tuananhse.fragment.fragment_movie.api.fragment_movie;
import com.tuananhse.fragment.fragment_movie.api.fragment_myaccountinfo;
import com.tuananhse.fragment.fragment_movie.api.presenter.MainPresenter;
import com.tuananhse.model.Movie;


import java.util.ArrayList;

public class MainActivity extends ActionBarActivity implements FragmentDrawer.FragmentDrawerListener {
    private static final String TAG=MainActivity.class.getSimpleName();
    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;

    //public MovieAdapter mainMovieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //hkoi tao ham goi callFragment
     //   callFragment(new fragment_myaccountinfo());
        mToolbar= (Toolbar) findViewById(R.id.toolbar);


        getSupportActionBar(mToolbar);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);
    }

    public void callFragment(Fragment fg) {
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.container_body,fg);
        transaction.commit();
    }

    private void getSupportActionBar(Toolbar mToolbar) {
    }


    @Override
    public void onDrawerItemSelected(View view, int position) {

    }
}
