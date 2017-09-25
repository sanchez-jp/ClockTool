package com.juanpedrosanchez.clocktool;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.os.SystemClock;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChronoActivity extends AppCompatActivity {
    private Button btnStart;
    private Button btnPause;
    private Button btnReset;
    private Button btnLap;
    private Button btnReloj;
    private Button btnChrono;
    private Chronometer chronometer;
    private ListView LV_vueltas;
    private ArrayList<String> lapList;
    private ArrayAdapter<String> adaptador; // Adaptador para el ListView
    private int lap;

    public void gestorBtnPause(){
        if(btnPause.getText().toString().equals("Pause")){
            chronometer.stop();
            btnPause.setText("Resume");
        }
        else if(btnPause.getText().toString().equals("Resume")){
            /*Se optiene el tiempo donde se hizo el stop y luego se calcula el tiempo que ha
            transcurrido. Una vez hecho esto se setea nuevamente el cronómetro y se inicia con
            start().*/
            btnPause.setText("Pause");
            int stoppedMilliseconds = 0;

            String chronoText = chronometer.getText().toString();
            String array[] = chronoText.split(":");
            if (array.length == 2) {
                stoppedMilliseconds = Integer.parseInt(array[0]) * 60 * 1000
                        + Integer.parseInt(array[1]) * 1000;
            } else if (array.length == 3) {
                stoppedMilliseconds = Integer.parseInt(array[0]) * 60 * 60 * 1000
                        + Integer.parseInt(array[1]) * 60 * 1000
                        + Integer.parseInt(array[2]) * 1000;
            }

            chronometer.setBase(SystemClock.elapsedRealtime() - stoppedMilliseconds);
            chronometer.start();
        }
    }

    public void addLap(){
        lapList.add(0,"Lap " + lap + ": " + chronometer.getText().toString());
        adaptador.notifyDataSetChanged();
        lap ++;
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
        lapList = new ArrayList<>();
        adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lapList);
        LV_vueltas = (ListView)findViewById(R.id.LV_vueltas);
        LV_vueltas.setAdapter(adaptador);
        lap = 1;

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

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnStart.setEnabled(true);
                btnPause.setText("Pause");
                chronometer.stop();
                chronometer.setBase(SystemClock.elapsedRealtime());

                lap = 1;
                lapList.clear();
                LV_vueltas.clearChoices();
            }
        });

        btnLap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addLap();
            }
        });
    }
}
