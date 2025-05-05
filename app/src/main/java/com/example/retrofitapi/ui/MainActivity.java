package com.example.retrofitapi.ui;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.retrofitapi.R;
import com.example.retrofitapi.adapter.TeamAdapter;
import com.example.retrofitapi.api.ApiClient;
import com.example.retrofitapi.api.ApiService;
import com.example.retrofitapi.model.Team;
import com.example.retrofitapi.model.TeamResponse;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TeamAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TeamAdapter(new ArrayList<>()); // Initialize with empty list
        recyclerView.setAdapter(adapter);

        // Get country parameter from Intent
        String selectedCountry = getIntent().getStringExtra("SELECTED_COUNTRY");

        // Set default country if no parameter passed
        if(selectedCountry == null || selectedCountry.isEmpty()) {
            selectedCountry = "Indonesia"; // Default value
        }

        fetchData(selectedCountry);
    }

    private void fetchData(String country) {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<TeamResponse> call = apiService.getTeams(country); // Use parameter

        call.enqueue(new Callback<TeamResponse>() {
            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Team> teams = response.body().getTeams();
                    if (teams != null && !teams.isEmpty()) {
                        adapter.updateData(teams); // Update adapter data
                    } else {
                        showToast("No teams found in " + country);
                    }
                } else {
                    showToast("Failed to load data");
                }
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable t) {
                showToast("Error: " + t.getMessage());
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}