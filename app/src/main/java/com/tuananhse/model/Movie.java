package com.tuananhse.model;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kyubj on 8/22/2016.
 */
public class Movie {
    //lấy ra một số thuộc tính của đối tượng
    @SerializedName("overview")
  public String overview;
    @SerializedName("release_date")
    public String release_date;
    @SerializedName("original_title")
    public String title;
//lấy đối tượng json
    public static Movie getMovie(JSONObject obj)
    {
        try {
            return new Movie(obj.getString(("title")),obj.getString(("release_date")),obj.getString(("overview")));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    //lấy dữ liệu
    public static ArrayList<Movie> getMovieData(JSONArray jsonArray)
    {
        ArrayList<Movie> arrMovie=new ArrayList<>();
        try {
            for(int i=0;i<jsonArray.length();i++)
            {
                arrMovie.add(Movie.getMovie(jsonArray.getJSONObject(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrMovie;
    }

    public Movie() {
    }

    public Movie(String overview, String release_date, String original_titel) {
        this.overview = overview;
        this.release_date = release_date;
        this.title = original_titel;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getOriginal_titel() {
        return title;
    }

    public void setOriginal_titel(String original_titel) {
        this.title = original_titel;
    }
}
