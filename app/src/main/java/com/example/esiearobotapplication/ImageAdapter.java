package com.example.esiearobotapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.esiearobotapplication.Others.Image;



import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyViewHolder>
{

    private Context mContext;
    private List<Image> standsList;

    public ImageAdapter(Context mContext, List<Image> standsList)
    {
        this.mContext = mContext;
        this.standsList = standsList;
    }

    @NonNull
    @Override
    public ImageAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v;
        LayoutInflater layoutInflater =  LayoutInflater.from(mContext);
        v = layoutInflater.inflate(R.layout.map_item,parent,false);
        return new ImageAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.MyViewHolder holder, int position)
    {

        Glide.with(mContext)
                .load(standsList.get(position).getBigImage())
                .into(holder.Image);
    }



    @Override
    public int getItemCount() {
        return standsList.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView Image;
        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            Image = itemView.findViewById(R.id.bigImage);

        }
    }




}
