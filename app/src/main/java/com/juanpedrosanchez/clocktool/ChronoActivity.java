package com.juanpedrosanchez.clocktool;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ChronoActivity extends AppCompatActivity {
    Button btnStart;
    Button btnPause;
    Button btnReset;
    Button btnLap;
    Button btnReloj;
    Button btnChrono;
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

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO
            }
        });
    }
}
