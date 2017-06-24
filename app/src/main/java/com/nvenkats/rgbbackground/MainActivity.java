package com.nvenkats.rgbbackground;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    MyColor color = new MyColor();
    private final int constant = 5;

    protected void displayBackground() {
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.rgb(color.getr(), color.getg(), color.getb()));
    }

    public void increaseRed() {
        color.setColor(color.getr()+constant, color.getg(), color.getb());
        displayBackground();
    }

    protected void increaseGreen() {
        color.setColor(color.getr(), color.getg()+constant, color.getb());
        displayBackground();
    }

    protected void increaseBlue() {
        color.setColor(color.getr(), color.getg(), color.getb()+constant);
        displayBackground();
    }
    protected void backToBlack() {
        color.setColor(0, 0, 0);
        displayBackground();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences;
        preferences = getSharedPreferences("Color", MODE_PRIVATE);
        int c = preferences.getInt("rbg_color", 0);
        color.setColor(c);
        displayBackground();

        Button bRed = (Button) findViewById(R.id.button);
        bRed.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                increaseRed();
            }
        });

        Button bGreen = (Button) findViewById(R.id.button2);
        bGreen.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                increaseGreen();
            }
        });

        Button bBlue = (Button) findViewById(R.id.button3);
        bBlue.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                increaseBlue();
            }
        });

        Button bReset = (Button) findViewById(R.id.button4);
        bReset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                backToBlack();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        displayBackground();
    }


    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    protected void onPause() {
        SharedPreferences.Editor editor = getSharedPreferences("Color", MODE_PRIVATE).edit();
        editor.putInt("rbg_color", color.getColor());
        editor.commit();
        super.onPause();
    }


    @Override
    protected void onStop() {
        super.onStop();
    }


    @Override
    protected void onRestart() {
        super.onRestart();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

}
