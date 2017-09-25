package com.juanpedrosanchez.clocktool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final String TAG = "MENSAJE DE LOG";
    /*Declaración de Campo de texto. Pié de hora "Reloj"*/
    TextView headingText;
    /*Declaración de Botón para acceder a cronómetro*/
    Button btnChrono;
    /*Declaración de Botón para acceder a contador*/
    Button btnCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Instanciación de headingText*/
        headingText = (TextView)findViewById(R.id.headingText);
        /*Instanciación de btnChrono*/
        btnChrono = (Button)findViewById(R.id.btnChrono);
        /*Instanciación de btnCount*/
        btnCount = (Button)findViewById(R.id.btnCount);

        /*Definición de acción para btnChrono*/
        btnChrono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChronoActivity.class);
                startActivity(intent);
            }
        });

        /*Definición de acción para btnCount*/
        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CounterActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG, "Comienzo");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG, "Pausa");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "Parado");
    }

    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Destruido");
    }
}
