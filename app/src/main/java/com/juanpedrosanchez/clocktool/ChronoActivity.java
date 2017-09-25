package com.juanpedrosanchez.clocktool;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.os.SystemClock;

public class ChronoActivity extends AppCompatActivity {
    Button btnStart;
    Button btnPause;
    Button btnReset;
    Button btnLap;
    Button btnReloj;
    Button btnChrono;
    Chronometer chronometer;

    String base;

    public void gestorBtnPause(){
        Log.d("BOTON PAUSE", btnPause.getText().toString());
        if(btnPause.getText().toString().equals("Pause")){
            chronometer.stop();
            btnPause.setText("Resume");
            base = chronometer.getText().toString();
        }
        else if(btnPause.getText().toString().equals("Resume")){
            chronometer.setText(base);
            chronometer.start();
            btnPause.setText("Pause");

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chrono);

        btnStart = (Button)findViewById(R.id.btnStart);
        btnPause = (Button)findViewById(R.id.btnPause);
        btnReset = (Button)findViewById(R.id.btnResetChrono);
        btnLap = (Button)findViewById(R.id.btnLap);
        btnReloj = (Button)findViewById(R.id.btnReloj);
        btnChrono = (Button)findViewById(R.id.btnChrono);
        chronometer = (Chronometer)findViewById(R.id.chronometer);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime()); // set base time for a chronometer
                chronometer.start();
                btnStart.setEnabled(false);
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gestorBtnPause();
            }
        });
    }
}
