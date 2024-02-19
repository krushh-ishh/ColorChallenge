package com.fun.codechallenge_app;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ColorActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button1, button2, button3, button4;
    private ImageButton pausePlayBtn;
    private TextView score, level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        initView();
        gamePlay();

    }

    private void gamePlay() {
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        List<String> colors = Arrays.asList("#FBFE7A", "#FF8D8D", "#7BCFCF", "#999DE7");
        Collections.shuffle(colors);
        button1.setBackgroundColor(Color.parseColor(colors.get(0)));
        button2.setBackgroundColor(Color.parseColor(colors.get(1)));
        button3.setBackgroundColor(Color.parseColor(colors.get(2)));
        button4.setBackgroundColor(Color.parseColor(colors.get(3)));
    }

    private void initView() {
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        score = findViewById(R.id.score);
        level = findViewById(R.id.level);

        pausePlayBtn = findViewById(R.id.pausePlay);
    }
}