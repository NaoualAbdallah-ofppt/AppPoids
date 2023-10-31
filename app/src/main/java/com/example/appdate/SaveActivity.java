package com.example.appdate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SaveActivity extends AppCompatActivity {
    TextView txt;
    EditText ETP;
    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

            txt = (TextView) findViewById(R.id.txtAccueil);
            ETP = (EditText) findViewById(R.id.txtPoids);
            btn1 = (Button) findViewById(R.id.btnEnregistrer);
            btn2 = (Button) findViewById(R.id.btnQuitter);
            DateFormat DF = new SimpleDateFormat("dd-MM-yyyy");
            txt.setText("Bonjour\nNous sommes le " + DF.format(new Date().getTime()));
            ETP.requestFocus();
            btn1.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view) {
                    try {
                        Mesure M = new Mesure(Float.parseFloat(ETP.getText().toString()));
                        Mesure.ajouter(M);
                        Toast.makeText(getApplicationContext(), "Mesure ajoutée", Toast.LENGTH_SHORT).show();
                        CountDownTimer CDT = new CountDownTimer(3000, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {

                            }

                            @Override
                            public void onFinish() {
                                finish();
                            }
                        };
                        CDT.start();
                    } catch (Exception ex) {
                        Toast.makeText(SaveActivity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

    }
}