package com.example.nektekproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Sejarah (View view) {
        Intent intent = new Intent(MainActivity.this, SejarahActivity.class);
        startActivity(intent);
    }

    public void Foto (View view) {
        Intent intent = new Intent(MainActivity.this, FotoActivity.class);
        startActivity(intent);
    }

    public void Video (View view) {
        Intent intent = new Intent(MainActivity.this, VideoActivity.class);
        startActivity(intent);
    }
}