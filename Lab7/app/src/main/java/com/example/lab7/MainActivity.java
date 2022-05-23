package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        boolean enabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        Button locationBtn = findViewById(R.id.locationBtn);
        locationBtn.setEnabled(enabled);
    }

    public void goToLocation(View v){
        startActivity(new Intent(getApplicationContext(), LocationActivity.class));
    }
    public void goToSensors(View view){
        Intent intent = new Intent(getApplicationContext(), SensorActivity.class);
        if (view.getId() == R.id.accelerationSensorBtn){
            intent.putExtra("SENSOR_TYPE", "ACC");
        }else {
            intent.putExtra("SENSOR_TYPE", "LIGHT");
        }
        System.out.println(intent.getExtras());
        startActivity(intent);
    }
    public void goToAllSensors(View view){
        startActivity(new Intent(getApplicationContext(), AllSensors.class));
    }
    public void goToCompass(View view){
        startActivity(new Intent(getApplicationContext(), Compass.class));
    }

}