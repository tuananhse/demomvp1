package com.tuananhse.fragment.fragment_movie.api.presenter;

import org.json.JSONArray;

/**
 * Created by kyubj on 8/23/2016.
 */
public interface FetchDataCallback {
    void onFetchSuccess(JSONArray data);
    void onFetchFault(Exception e);
}
