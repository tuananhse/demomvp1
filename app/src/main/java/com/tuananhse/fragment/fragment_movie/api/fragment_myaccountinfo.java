package com.tuananhse.fragment.fragment_movie.api;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tuananhse.examplematerialretrofitmvp.R;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by kyubj on 8/24/2016.
 */
public class fragment_myaccountinfo extends Fragment {
    private static final int NUM_PAGE=2;
    private Button btnperson,btnappointment;
    private ViewPager mPager;
    ScreenSlidePagerAdapter adapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v=inflater.inflate(R.layout.activity_account_info,container,false);
        mPager= (ViewPager) v.findViewById(R.id.pagerslide);
       setupViewPager(mPager);
        return v;
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new ScreenSlidePagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new FragmentButton());
        //
        adapter.addFragment(new FragmentAppointment());

        viewPager.setAdapter(adapter);
    }



    class ScreenSlidePagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList=new ArrayList<>();


        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }
        public void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);

        }
        @Override
        public int getCount() {
            return NUM_PAGE;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return (CharSequence) mFragmentList.get(position);
        }
    }
}
