package com.juanpedrosanchez.clocktool;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CounterActivity extends AppCompatActivity {
    final String TAG = "MENSAJE DE LOG";

    /*Declaración de botón reset*/
    Button btnReset;
    /*Declaración de botón de incremento del contador*/
    ImageButton btnIncrement;
    /*Declaración de texto de contador*/
    TextView txtCounter;
    /*Declaración del botón para volver a la actividad reloj*/
    Button btnReloj;
    /*Declaración de botón para ir a la actividad cronómetro*/
    Button btnChrono;
    /*Atributo con el valor del contador*/
    int counter;

    /*Atributos para guardar estado*/
    private final static String COUNTERSTATE = "counter_state";

    public void increment(){
        counter ++;
        txtCounter.setText(String.valueOf(counter));
    }

    public void reset(){
        counter = 0;
        txtCounter.setText(String.valueOf(counter));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        /*Instanciación de elementos*/
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(COUNTERSTATE);
        }
        txtCounter = (TextView)findViewById(R.id.txtCounter);
        txtCounter.setText(String.valueOf(counter));
        btnIncrement = (ImageButton)findViewById(R.id.btnIncrement);
        btnReset = (Button)findViewById(R.id.btnReset);
        btnReloj = (Button)findViewById(R.id.btnReloj);
        btnChrono = (Button)findViewById(R.id.btnChrono);

        /*Definición de acción para btnIncrement*/
        btnIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increment();
            }
        });

        /*Definición de acción para btnReset*/
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });

        /*Definición de acción para btnReloj*/
        btnReloj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CounterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        /*Definición de acción para btnChrono*/
        btnChrono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CounterActivity.this, ChronoActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(COUNTERSTATE, counter);
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG, "Comienzo contador");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG, "Pausa contador");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "Parado contador");
    }

    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Destruido contador");
    }
}
