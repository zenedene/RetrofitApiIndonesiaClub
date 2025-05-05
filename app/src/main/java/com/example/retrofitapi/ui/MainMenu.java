package com.example.retrofitapi.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.retrofitapi.R;

public class MainMenu extends AppCompatActivity {

    private Button btnIndonesia, btnMalaysia,btnJapan, btnItaly, btnGermany, btnFrance, btnNetherlands, btnPortugal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        btnIndonesia = findViewById(R.id.btn_indonesia);
        btnMalaysia = findViewById(R.id.btn_malaysia);
        btnJapan = findViewById(R.id.btn_japan);
        btnItaly = findViewById(R.id.btn_italy);
        btnGermany = findViewById(R.id.btn_germany);
        btnFrance = findViewById(R.id.btn_france);
        btnNetherlands = findViewById(R.id.btn_netherlands);
        btnPortugal = findViewById(R.id.btn_portugal);

        // Click listener untuk semua tombol
        View.OnClickListener countryClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String country = "";
                int id = v.getId();

                if (id == R.id.btn_indonesia) {
                    country = "Indonesia";
                } else if (id == R.id.btn_malaysia) {
                    country = "Malaysia";
                } else if (id == R.id.btn_japan) {
                    country = "Japan";
                } else if (id == R.id.btn_italy) {
                    country = "Italy";
                } else if (id == R.id.btn_germany) {
                    country = "Germany";
                } else if (id == R.id.btn_france) {
                    country = "France";
                } else if (id == R.id.btn_netherlands) {
                    country = "Netherlands";
                } else if (id == R.id.btn_portugal) {
                    country = "Portugal";
                }

                // Pindah ke MainActivity
                Intent intent = new Intent(MainMenu.this, MainActivity.class);
                intent.putExtra("SELECTED_COUNTRY", country);
                startActivity(intent);
            }
        };

        btnIndonesia.setOnClickListener(countryClickListener);
        btnMalaysia.setOnClickListener(countryClickListener);
        btnJapan.setOnClickListener(countryClickListener);
        btnItaly.setOnClickListener(countryClickListener);
        btnGermany.setOnClickListener(countryClickListener);
        btnFrance.setOnClickListener(countryClickListener);
        btnNetherlands.setOnClickListener(countryClickListener);
        btnPortugal.setOnClickListener(countryClickListener);
    }
}