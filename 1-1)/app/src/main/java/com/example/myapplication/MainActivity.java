package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private EditText et1;
    private EditText et2;
    private TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void somar(View view)
    {
        et1 = (EditText) findViewById(R.id.text_number1);
        et2 = (EditText) findViewById(R.id.text_number2);

        res = (TextView) findViewById(R.id.res);

        String et1Text = et1.getText().toString();
        String et2Text = et2.getText().toString();

        String result = Integer.toString(Integer.parseInt(et1Text) + Integer.parseInt(et2Text));

        res.setText(result);
    }

    public void Send(View view)
    {
        Intent i = new Intent(this, MainActivity2.class);
        i.putExtra("data", res.getText().toString());
        startActivity(i);
    }
}