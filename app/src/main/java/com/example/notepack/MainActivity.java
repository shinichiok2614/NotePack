package com.example.notepack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageViewAddNode = (ImageView) findViewById(R.id.imageViewAddNote);
        imageViewAddNode.setClickable(true);
        imageViewAddNode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.imageViewAddNote) {
            Intent intent = new Intent(MainActivity.this, NoteActivity.class);
            startActivity(intent);
        }
    }
}