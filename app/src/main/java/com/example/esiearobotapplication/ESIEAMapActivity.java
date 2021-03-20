package com.example.esiearobotapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static com.example.esiearobotapplication.ESIEAStandActivity.EXTRA_LIEU;
import static com.example.esiearobotapplication.ESIEAStandActivity.EXTRA_MAP;
import static com.example.esiearobotapplication.ESIEAStandActivity.EXTRA_STAND;
import static com.example.esiearobotapplication.ESIEAStandActivity.EXTRA_URL;

/**
 *
 *
 * @author Onur Can Kadioglu
 * @version 1.0
 */

public class ESIEAMapActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esiea_map);

        Intent intent = getIntent();
        String image = intent.getStringExtra(EXTRA_URL);
        String stand = intent.getStringExtra(EXTRA_STAND);
        String map = intent.getStringExtra(EXTRA_MAP);
        String lieu = intent.getStringExtra(EXTRA_LIEU);

        ImageView imageView = findViewById(R.id.image_view_detail);
        TextView textViewStand = findViewById(R.id.text_view_stand_detail);
        TextView textViewLieu = findViewById(R.id.text_view_lieu_detail);
        TextView textViewMap = findViewById(R.id.text_view_conference_detail);

        Picasso.get().load(image).resize(2048,605).into(imageView);
        textViewStand.setText(stand);
        textViewLieu.setText(lieu);
        textViewMap.setText(map);
    }
}