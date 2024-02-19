package com.fun.codechallenge_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ColorActivity extends AppCompatActivity {

    private Button button1, button2, button3, button4;
    private ImageButton pausePlayBtn;
    private TextView score, level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        initView();

        button1.setOnClickListener( v ->
                Toast.makeText(this,"button1", Toast.LENGTH_LONG).show());
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