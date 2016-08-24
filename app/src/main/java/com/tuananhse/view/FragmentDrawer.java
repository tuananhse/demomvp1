package com.tuananhse.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tuananhse.adapter.NavigationDrawerAdapter;
import com.tuananhse.examplematerialretrofitmvp.R;
import com.tuananhse.fragment.fragment_movie.api.fragment_movie;
import com.tuananhse.fragment.fragment_movie.api.fragment_myaccountinfo;
import com.tuananhse.model.NavDrawerItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kyubj on 8/22/2016.
 */
public class FragmentDrawer extends Fragment  {
    private static String TAG = FragmentDrawer.class.getSimpleName();
    private Context context;
    private RecyclerView recyclerView;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private NavigationDrawerAdapter adapter;
    private View containerView;
    private static String[] titles = null;
    private FragmentDrawerListener drawerListener;
    private android.support.v4.app.Fragment fragment_myaccountinfo;

    public FragmentDrawer() {

    }

    public void setDrawerListener(MainActivity listener) {
        this.drawerListener = listener;
    }

    public static List<NavDrawerItem> getData() {
        List<NavDrawerItem> data = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            NavDrawerItem navItem = new NavDrawerItem();
            navItem.setTitle(titles[i]);
            data.add(navItem);
        }
        return data;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        titles = getActivity().getResources().getStringArray(R.array.nav_drawer_labels);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.nav_drawer_display, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.drawerList);

        adapter = new NavigationDrawerAdapter(getActivity(), getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView,  new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                drawerListener.onDrawerItemSelected(view, position);
                switch (position)
                {
                    case 0:
                    {
                        Toast.makeText(getActivity(),"màn hình 1",Toast.LENGTH_LONG).show();
                        //fragment_movie fr_movie= (com.tuananhse.fragment.fragment_movie.api.fragment_movie) getActivity().getSupportFragmentManager().findFragmentById(R.id.fragmentmovie);
                        //fr_movie
                            
                       /* MainActivity add = (MainActivity)FragmentDrawer.this.getActivity();
                        add.callFragment(fragment_movie);*/

                    }break;
                    case 1:
                    {
                        Fragment fg=new fragment_myaccountinfo();
                        Toast.makeText(getActivity(),"màn hình 2",Toast.LENGTH_LONG).show();
                        {
                            FragmentManager manager=getActivity().getSupportFragmentManager();
                            FragmentTransaction transaction=manager.beginTransaction();

                            transaction.replace(R.id.container_body,fg);
                            transaction.commit();
                        }

                    }break;
                    case 2:
                    {
                        Toast.makeText(getActivity(),"màn hình 3",Toast.LENGTH_LONG).show();
                    }break;
                    case 3:
                    {
                        Toast.makeText(getActivity(),"màn hình 4",Toast.LENGTH_LONG).show();
                        Fragment fg=new fragment_myaccountinfo();
                        Toast.makeText(getActivity(),"màn hình 2",Toast.LENGTH_LONG).show();
                        {
                            FragmentManager manager=getActivity().getSupportFragmentManager();
                            FragmentTransaction transaction=manager.beginTransaction();

                            transaction.replace(R.id.container_body,fg);
                            transaction.commit();
                        }
                    }break;
                }

                mDrawerLayout.closeDrawer(containerView);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        return layout;
    }

    public void setUp(int fragmentId, DrawerLayout drawerLayout, final Toolbar toolbar) {
        containerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar,     R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                toolbar.setAlpha(1 - slideOffset / 2);
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

    }

    public static interface ClickListener {
        public void onClick(View view, int position);

        public void onLongClick(View view, int position);
    }

    static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final    ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new  GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }


    }

    public interface FragmentDrawerListener {
        public void onDrawerItemSelected(View view, int position);

    }
}
