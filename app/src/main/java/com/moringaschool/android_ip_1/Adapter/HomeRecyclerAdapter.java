package com.moringaschool.android_ip_1.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.android_ip_1.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeViewHolder>{

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
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


