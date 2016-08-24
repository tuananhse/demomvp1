package com.tuananhse.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tuananhse.examplematerialretrofitmvp.R;
import com.tuananhse.model.Movie;

import org.json.JSONArray;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kyubj on 8/22/2016.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private ArrayList<Movie> movies;
    public LayoutInflater inflater;
    private Context context;
    //private AbstractQueue data1;

    public MovieAdapter(Context context, JSONArray data) {

        this.context = context;
        Movie.getMovieData(data);
    }

    public MovieAdapter(Context context,ArrayList<Movie> movies ) {
        this.movies = movies;
        this.context = context;
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.item_movie,null);
        MovieViewHolder cell=new MovieViewHolder(v);//trả về dòng dữ liệu
        return cell;
    }

    @Override
    public void onBindViewHolder(MovieAdapter.MovieViewHolder holder,final int position) {
        if(movies!=null)
        {
            final Movie cell=this.movies.get(position);//lấy ra vị trí trong mảng ArrayListMovie
            //  Toast.makeText(context,"vị trí"+position,Toast.LENGTH_LONG).show();
            //đưa dữ liệu lên giao diện
            holder.titleMovie.setText(cell.getOverview());
            holder.releaseDate.setText(cell.getRelease_date());
            holder.dataOverview.setText(cell.getOriginal_titel());
            holder.moviesLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),cell.getOriginal_titel(),Toast.LENGTH_LONG).show();
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void setData(JSONArray array)
    {
        ArrayList<Movie> data1=Movie.getMovieData(array);
        setData(data1);
    }

    private void setData(ArrayList<Movie> movies) {
        this.movies.clear();
        this.movies.addAll(movies);
        notifyDataSetChanged();
    }
    public class MovieViewHolder extends RecyclerView.ViewHolder {
        public TextView titleMovie;
        public TextView releaseDate;
        public TextView dataOverview;
        //layout cho các item hiển thị
        public LinearLayout moviesLayout;
        public MovieViewHolder(View v) {
            super(v);
            //ánh xạ giao diện
            moviesLayout= (LinearLayout) v.findViewById(R.id.movies_layout);
            titleMovie= (TextView) v.findViewById(R.id.title1);
            releaseDate= (TextView) v.findViewById(R.id.date);
            dataOverview= (TextView) v.findViewById(R.id.overview);
        }
    }
}
