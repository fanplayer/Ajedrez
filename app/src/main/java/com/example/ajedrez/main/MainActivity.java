package com.example.ajedrez.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ajedrez.R;
import com.example.ajedrez.activities.SecondActivity;

public class MainActivity extends AppCompatActivity {

    private EditText nombre;
    private Button acceder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        acceder = findViewById(R.id.boton1);
        nombre = findViewById(R.id.nombre);

    }

    public void Acceder(View view){
        Intent i = new Intent(getBaseContext(), SecondActivity.class);
        i.putExtra("nombre",nombre.getText().toString());
        startActivityForResult(i,RESULT_OK);
        finish();
    }
}