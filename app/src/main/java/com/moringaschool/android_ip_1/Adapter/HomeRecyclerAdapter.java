package com.moringaschool.android_ip_1.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.android_ip_1.Models.SearchEndPoint.SearchArrayObject;
import com.moringaschool.android_ip_1.R;
import com.moringaschool.android_ip_1.UI.OnMovieClickListener;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeViewHolder>{

    Context context;
    List<SearchArrayObject> list;
    OnMovieClickListener listener;

    public HomeRecyclerAdapter(Context context, List<SearchArrayObject> list, OnMovieClickListener listener) {

        this.context = context;
        this.list = list;
        this.listener = listener;

    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new HomeViewHolder(LayoutInflater.from(context).inflate(R.layout.home_movies_list,parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.tvViewMovie.setText(list.get(position).getTitle());
        holder.tvViewMovie.setSelected(true); //horizontal scrolling thingy
        Picasso.get().load(list.get(position).getImage()).into(holder.ivPoster);

        holder.cvHomeContainer.setOnClickListener(new View.OnClickListener() {  //set onClickLister to each movie inside our RecyclerView

            @Override
            public void onClick(View v) {

                listener.onMovieClicked(list.get(position).getId()); //defined in the interface.

            }

        });

    }

    @Override
    public int getItemCount() {

        return list.size();

    }
}

//ViewHolder.
class HomeViewHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.ivPoster) ImageView ivPoster;
    @BindView(R.id.tvViewMovie) TextView tvViewMovie;
    @BindView(R.id.cvHomeContainer) CardView cvHomeContainer;

    //constructor matching super-class.
    public HomeViewHolder(@NonNull View itemView) {

        super(itemView);
        ButterKnife.bind(this,itemView);

    }

}


