package com.tuananhse.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tuananhse.examplematerialretrofitmvp.R;
import com.tuananhse.model.NavDrawerItem;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by kyubj on 8/22/2016.
 */
public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.MyviewHolder> {
    List<NavDrawerItem> data= Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;

    public NavigationDrawerAdapter(Context context,List<NavDrawerItem> data) {
        this.data = data;
       inflater=LayoutInflater.from(context);
        this.context = context;
    }
    public void delete(int position)
    {
        data.remove(position);
        notifyItemRemoved(position);
    }
    @Override
    public MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.nav_drawer_row,parent,false);
        MyviewHolder holder=new MyviewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyviewHolder holder, int position) {
    NavDrawerItem cuNavDrawerItem=data.get(position);
        holder.title.setText(cuNavDrawerItem.getTitle());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView title;
        public MyviewHolder(View itemView) {
            super(itemView);
            title= (TextView) itemView.findViewById(R.id.title);
        }
    }
}
