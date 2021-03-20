package com.example.esiearobotapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.esiearobotapplication.Others.Image;
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
 * @version 0.1
 */


public class MainActivity extends AppCompatActivity
{

    RecyclerView recyclerView;
    List<Image> imageList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureEsieaButton();
        configureIntechButton();

        recyclerView = findViewById(R.id.esieaRecyclerView);
        imageList = new ArrayList<>();


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
                imageList = new ArrayList<>(Arrays.asList(jsonResponse.getSecondImage()));

                PutDataInRecyclerView(imageList);
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {

            }
        });
    }

    private void PutDataInRecyclerView(List<Image> imageList)
    {
        ImageAdapter imageAdapter = new ImageAdapter(this,imageList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(imageAdapter);
    }


    private void configureEsieaButton()
    {
        Button esieaButton = (Button) findViewById(R.id.esiea_button);
        esieaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ESIEAStandActivity.class));
            }
        });
    }

    private void configureIntechButton ()
    {
        Button intechButton = (Button) findViewById(R.id.intech_button);
        intechButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this, INTECHStandActivity.class));
            }
        });
    }

}
