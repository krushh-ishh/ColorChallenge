package com.fun.codechallenge_app;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ColorActivity extends AppCompatActivity implements View.OnClickListener{
    private Button b;
    int scoreValue = 0, levelValue = 1;
    private Button button1, button2, button3, button4;
    private ImageButton pausePlayBtn;
    private TextView score, level, colorValue;
    private final int interval = 5000; // 1 Second
    long currentTime = System.currentTimeMillis() + 60 * interval;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        initView();
        gamePlay();

    }

    private void gamePlay() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                   checkIfClicked();
                }
            }

            private void checkIfClicked() {
                if(currentTime < SystemClock.uptimeMillis()) {
                    endGame();
                }
            }
        }).start();
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(b.getId() == v.getId()){
            scoreValue += 500;
            //score should be updated based on how early clicked
            score.setText(String.valueOf(scoreValue));
            Toast.makeText(this, "matched", Toast.LENGTH_SHORT).show();
        }
        else {
            endGame();
        }
        b = setRandomButtonColor();
        currentTime = SystemClock.uptimeMillis() + interval;
    }

    private void endGame() {
        TimeIsUp fragmentB = new TimeIsUp();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, fragmentB)
                .addToBackStack(TimeIsUp.class.getSimpleName())
                .commit();
    }

    private Button setRandomButtonColor() {
        List<String> colors = Arrays.asList("#FBFE7A", "#FF8D8D", "#7BCFCF", "#999DE7");
        Collections.shuffle(colors);
        //generate random index `
        colorValue.setBackgroundColor(Color.parseColor(colors.get(0)));
        String chosenColor = colors.get(0);

        Collections.shuffle(colors);
        int index = colors.indexOf(chosenColor);
        button1.setBackgroundColor(Color.parseColor(colors.get(0)));
        button2.setBackgroundColor(Color.parseColor(colors.get(1)));
        button3.setBackgroundColor(Color.parseColor(colors.get(2)));
        button4.setBackgroundColor(Color.parseColor(colors.get(3)));

        switch(index) {
            case 0 : return button1;
            case 1 : return button2;
            case 2 : return button3;
            case 3 : return button4;
            default: return null;
        }
    }

    private void initView() {
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        score = findViewById(R.id.score);
        score.setText(String.valueOf(scoreValue));
        level = findViewById(R.id.level);
        level.setText(String.valueOf(levelValue));
        colorValue = findViewById(R.id.colorValue);

        pausePlayBtn = findViewById(R.id.pausePlay);

        b = setRandomButtonColor();
    }
}