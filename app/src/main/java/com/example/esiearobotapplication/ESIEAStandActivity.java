    package com.example.esiearobotapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.esiearobotapplication.Others.JSONResponse;
import com.example.esiearobotapplication.Others.Stand;
import com.example.esiearobotapplication.Others.StandAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

    /**
     *
     *
     * @author Onur Can Kadioglu
     * @version 1.0
     */

public class ESIEAStandActivity extends AppCompatActivity implements StandAdapter.OnItemClickListener {

    public static final String EXTRA_URL = "image";
    public static final String EXTRA_STAND ="stand";
    public static final String EXTRA_LIEU = "lieu";
    public static final String EXTRA_DESCRIPTION = "description";
    public static final String EXTRA_CONFERENCE = "conference";
    public static final String EXTRA_MAP = "map";

    RecyclerView recyclerView;
    List<Stand> standList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esiea_stand);

        recyclerView = findViewById(R.id.esieaRecyclerView);
        standList = new ArrayList<>();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gist.githubusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        StandAPI standAPI = retrofit.create(StandAPI.class);

        Call<JSONResponse> call = standAPI.getStands();
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                JSONResponse jsonResponse = response.body();
                standList = new ArrayList<>(Arrays.asList(jsonResponse.getEsieaStands()));

                PutDataInRecyclerView(standList);
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {

            }
        });
    }

    private void PutDataInRecyclerView(List<Stand> standList)
    {
        StandAdapter standAdapter = new StandAdapter(this,standList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(standAdapter);
        standAdapter.setOnClickListener(this);
    }

    @Override
    public void onItemCLick(int position) {
        Intent mapIntent = new Intent(this, ESIEAMapActivity.class);
        Stand clickedItem = standList.get(position);
        
        mapIntent.putExtra(EXTRA_STAND,  clickedItem.getStand());
        mapIntent.putExtra(EXTRA_LIEU,  clickedItem.getLieu());
        mapIntent.putExtra(EXTRA_DESCRIPTION,  clickedItem.getDescription());
        mapIntent.putExtra(EXTRA_CONFERENCE,  clickedItem.getConference());
        mapIntent.putExtra(EXTRA_URL,  clickedItem.getImage());
        mapIntent.putExtra(EXTRA_MAP,  clickedItem.getMap());

        startActivity(mapIntent);
    }
}