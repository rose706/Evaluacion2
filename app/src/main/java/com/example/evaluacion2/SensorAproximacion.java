package com.example.evaluacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SensorAproximacion extends AppCompatActivity implements SensorEventListener {

    TextView tvl;
    LinearLayout ln;
    SensorManager sm;
    Sensor sensor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_aproximacion);
        tvl = (TextView) findViewById(R.id.tv);
        ln = (LinearLayout) findViewById(R.id.activityid);
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sm.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        String sensorl = String.valueOf(sensorEvent.values[0]);
        tvl.setText(sensorl);
        float valor = Float.parseFloat(sensorl);
        if (valor == 0){
            ln.setBackgroundColor(Color.BLUE);
        }else{
            ln.setBackgroundColor(Color.RED);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}