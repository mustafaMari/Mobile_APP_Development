package com.example.lab7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class LocationActivity extends AppCompatActivity implements LocationListener {
    boolean deniedOnc = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_actitvity);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onResume() {
        super.onResume();
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            ((TextView)findViewById(R.id.latitude)).setText("Not Applicable");
            ((TextView)findViewById(R.id.longitude)).setText("Not Applicable");
            ((TextView)findViewById(R.id.altitude)).setText("Not Applicable");
            ((TextView)findViewById(R.id.speed)).setText("Not Applicable");

        }else {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 500,1, this);
            }else if(!deniedOnc){
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
            } else {
                ((TextView)findViewById(R.id.latitude)).setText("No Access");
                ((TextView)findViewById(R.id.longitude)).setText("No Access");
                ((TextView)findViewById(R.id.altitude)).setText("No Access");
                ((TextView)findViewById(R.id.speed)).setText("No Access");
            }
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        ((LocationManager) getSystemService(LOCATION_SERVICE)).removeUpdates(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_SHORT).show();
        }else{
            deniedOnc = true;
            Toast.makeText(getApplicationContext(), "Permission Denied", Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onLocationChanged(@NonNull Location location) {
        ((TextView)findViewById(R.id.latitude)).setText(Double.toString(location.getLatitude()));
        ((TextView)findViewById(R.id.longitude)).setText(Double.toString(location.getLongitude()));
        ((TextView)findViewById(R.id.altitude)).setText(Double.toString(location.getAltitude()));
        ((TextView)findViewById(R.id.speed)).setText(Double.toString(location.getSpeed()));
    }
}