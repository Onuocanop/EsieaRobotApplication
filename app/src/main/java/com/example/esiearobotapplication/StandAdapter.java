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
import com.example.esiearobotapplication.Others.Stand;

import java.util.List;

/**
 *
 *
 * @author Onur Can Kadioglu
 * @version 1.0
 */


public class StandAdapter extends RecyclerView.Adapter<StandAdapter.MyViewHolder>
{
    private Context mContext;
    private List<Stand> standsList;
    private static OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemCLick(int position);
    }

    public void setOnClickListener(OnItemClickListener listener)
    {
        mListener = listener;
    }

    public StandAdapter(Context mContext, List<Stand> standsList)
    {
        this.mContext = mContext;
        this.standsList = standsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v;
        LayoutInflater layoutInflater =  LayoutInflater.from(mContext);
        v = layoutInflater.inflate(R.layout.stand_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {

        holder.standName.setText(standsList.get(position).getStand());
        holder.standLieu.setText(standsList.get(position).getLieu());
        holder.standDescription.setText(standsList.get(position).getDescription());
        holder.standConference.setText(standsList.get(position).getConference());
      //  holder.standMap.setText(standsList.get(position).getMap());

        Glide.with(mContext)
                .load(standsList.get(position).getImage())
                .into(holder.standImage);
    }

    @Override
    public int getItemCount() {
        return standsList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView standName;
        TextView standLieu;
        TextView standDescription;
        TextView standConference;
        ImageView standImage;
       // TextView standMap;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);

            standName = itemView.findViewById(R.id.stand_name);
            standLieu = itemView.findViewById(R.id.stand_lieu);
            standDescription = itemView.findViewById(R.id.stand_description);
            standConference = itemView.findViewById(R.id.stand_conference);
            standImage = itemView.findViewById(R.id.stand_image);

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    if(mListener != null)
                    {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION)
                        {
                            mListener.onItemCLick(position);
                        }
                    }
                }
            });
        }
    }
}
