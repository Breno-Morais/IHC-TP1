package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private TextView coorX;
    private TextView coorY;
    private TextView coorZ;
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;

    final int limite = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coorX = (TextView) findViewById(R.id.textX);
        coorY = (TextView) findViewById(R.id.textY);
        coorZ = (TextView) findViewById(R.id.textZ);
    }
    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()== Sensor.TYPE_ACCELEROMETER) {
            float sensorX = event.values[0];
            float sensorY = event.values[1];
            float sensorZ = event.values[2];

            if(sensorX > limite || sensorY > limite || sensorZ > limite)
            {
                Intent i = new Intent(this, MainActivity2.class);
                startActivity(i);
            }

            String resX = "X: " + String.valueOf(sensorX);
            coorX.setText(resX);

            String resY = "Y: " + String.valueOf(sensorY);
            coorY.setText(resY);

            String resZ = "Z: " + String.valueOf(sensorZ);
            coorZ.setText(resZ);
        }
    }
}