package com.example.ajedrez.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ajedrez.R;

public class SecondActivity extends AppCompatActivity {

    private TextView nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        nombre = findViewById(R.id.recibenombre);
        nombre.setText(getIntent().getStringExtra("nombre"));
    }

    public void Jugar(View view){
        Intent i = new Intent(this, TercerActivity.class);
        startActivity(i);
    }

}