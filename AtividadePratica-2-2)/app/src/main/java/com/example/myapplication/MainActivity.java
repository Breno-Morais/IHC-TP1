package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private TextView cooX;
    private TextView cooY;
    private TextView cooZ;
    private SensorManager sensorManager;
    private Sensor sensor;

    final int limite = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cooX = (TextView) findViewById(R.id.textX);
        cooY = (TextView) findViewById(R.id.textY);
        cooZ = (TextView) findViewById(R.id.textZ);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()== Sensor.TYPE_GYROSCOPE) {
            float axisX = event.values[0];
            float axisY = event.values[1];
            float axisZ = event.values[2];

            String resX = "X: " + axisX;
            cooX.setText(resX);

            String resY = "Y: " + axisY;
            cooY.setText(resY);

            String resZ = "Z: " + axisZ;
            cooZ.setText(resZ);
        }
    }
}