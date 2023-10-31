package com.example.appdate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {
ListView LV;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
       // Log.i("aa",String.valueOf(Mesure.getLstMesures().size()));

        ArrayAdapter<Mesure> AA = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1,Mesure.getLstMesures());
        LV=findViewById(R.id.lvMesures);

        LV.setAdapter(AA);
        btn=findViewById(R.id.btnQuitter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}