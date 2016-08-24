package com.tuananhse.fragment.fragment_movie.api;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tuananhse.examplematerialretrofitmvp.R;


/**
 * Created by kyubj on 8/18/2016.
 */
public class FragmentButton extends Fragment {
    public FragmentButton() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_viewpage_personal_profile, container, false);
    }
}
