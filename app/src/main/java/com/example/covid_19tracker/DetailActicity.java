package com.example.covid_19tracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class DetailActicity extends AppCompatActivity {

    private int positioncountry;
    TextView tvCountry,tvCases,tvRecovered,tvCritical,tvActive,tvTodayCases,tvTotalDeaths,tvTodayDeaths;
    PieChart pieChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_acticity);

        Intent intent = getIntent();
        positioncountry = intent.getIntExtra("position", 0);

        getSupportActionBar().setTitle("Details of "+AffectedCountries.countryModelList.get(positioncountry).getCountry());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        tvCountry = findViewById(R.id.tvCountry);
        tvCases = findViewById(R.id.tvCases);
        tvRecovered = findViewById(R.id.tvRecovered);
        tvCritical = findViewById(R.id.tvCritical);
        tvActive = findViewById(R.id.tvActive);
        tvTodayCases = findViewById(R.id.tvTodayCases);
        tvTotalDeaths = findViewById(R.id.tvDeaths);
        tvTodayDeaths = findViewById(R.id.tvTodayDeaths);
        pieChart = findViewById(R.id.piechartCountry);

        tvCountry.setText(AffectedCountries.countryModelList.get(positioncountry).getCountry());
        tvCases.setText(AffectedCountries.countryModelList.get(positioncountry).getCases());
        tvRecovered.setText(AffectedCountries.countryModelList.get(positioncountry).getRecovered());
        tvCritical.setText(AffectedCountries.countryModelList.get(positioncountry).getCritical());
        tvActive.setText(AffectedCountries.countryModelList.get(positioncountry).getActive());
        tvTodayCases.setText(AffectedCountries.countryModelList.get(positioncountry).getTodayCases());
        tvTotalDeaths.setText(AffectedCountries.countryModelList.get(positioncountry).getDeaths());
        tvTodayDeaths.setText(AffectedCountries.countryModelList.get(positioncountry).getTodayDeaths());
        pieChart.addPieSlice(new PieModel("Cases", Integer.parseInt(tvCases.getText().toString()), Color.parseColor("#FFA726")));
        pieChart.addPieSlice(new PieModel("Recovered",Integer.parseInt(tvRecovered.getText().toString()), Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(new PieModel("Deaths",Integer.parseInt(tvTotalDeaths.getText().toString()), Color.parseColor("#EF5350")));
        pieChart.addPieSlice(new PieModel("Active",Integer.parseInt(tvActive.getText().toString()), Color.parseColor("#29B6F6")));
        pieChart.startAnimation();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
