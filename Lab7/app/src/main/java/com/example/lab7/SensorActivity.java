package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Locale;

public class SensorActivity extends AppCompatActivity implements SensorEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onResume() {
        super.onResume();


        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Intent intent = getIntent();

        List<Sensor> sensors = sensorManager.getSensorList(intent.getStringExtra("SENSOR_TYPE").equals("LIGHT") ? Sensor.TYPE_LIGHT : Sensor.TYPE_ACCELEROMETER);
        ((TextView) findViewById(R.id.sensorType)).setText(intent.getStringExtra("SENSOR_TYPE"));
        if (sensors.isEmpty()){

            ((TextView) findViewById(R.id.sensorCount)).setText("0");
            ((TextView) findViewById(R.id.sensorValue)).setText("Not applicable");
        }
        else {
            ((TextView) findViewById(R.id.sensorCount)).setText(Integer.toString(sensors.size()));
            sensorManager.registerListener(this, sensors.get(0), 100_000, 1_000);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        ((SensorManager) getSystemService(SENSOR_SERVICE)).unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Intent intent = getIntent();
        if(intent.getStringExtra("SENSOR_TYPE").equals("LIGHT")){
            ((TextView)findViewById(R.id.sensorValue)).setText(String.format(Locale.US,"value: %f, accuracy: %d", event.values[0], event.accuracy));

        }else{

            ((TextView)findViewById(R.id.sensorValue)).setText(String.format(Locale.US,"value x: %f, value y: %f, value z: %f, accuracy: %d", event.values[0], event.values[1], event.values[2], event.accuracy));

        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}