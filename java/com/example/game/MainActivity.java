package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void launchStageOne(View v){

        Class randomActivity = ActivityManager1.getRandomActivity();
        Intent intent = new Intent(MainActivity.this, randomActivity);
        startActivity(intent);
        finish(); // Finish the main activity to prevent going back to it
    }
}