package com.example.evaluacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class Sensorhumedad extends AppCompatActivity implements SensorEventListener {
    private TextView textview;
    private SensorManager sensorManager;
    private Sensor humiditySensor;
    private Boolean isHumiditySensorAvailable;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensorhumedad);

        textview = findViewById(R.id.textView);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        if(sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY) !=null){
            humiditySensor = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
            isHumiditySensorAvailable = true;
        }else{
            textview.setText("Humidity sensor is not available");
            isHumiditySensorAvailable = false;
        }

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        textview.setText(sensorEvent.values[0] + "&");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
    @Override
    protected  void onResume(){
        super.onResume();
        if(isHumiditySensorAvailable)
        {
            sensorManager.registerListener(this,humiditySensor,SensorManager.SENSOR_DELAY_NORMAL);

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(isHumiditySensorAvailable)
        {
            sensorManager.unregisterListener(this);
        }
    }
}
