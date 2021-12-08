package com.example.evaluacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"Test",Toast.LENGTH_SHORT).show();
    }
    public void  Sensoraproximacion (View view) {
        Intent i = new Intent(this,SensorAproximacion.class);
        startActivity(i);
    }
      public void  SensorHumedad (View view) {
        Intent i = new Intent (this,Sensorhumedad.class);
        startActivity(i);
      }
      public void GPS_MAPS (View view){
        Intent i = new Intent(this,GPS_MAPS.class);
        startActivity(i);
      }
      public void BaseDeDatos (View view){
        Intent i = new Intent(this,BaseDeDatos.class);
        startActivity(i);

    }

    public void SensorMovimiento (View view){
        Intent i= new Intent(this,SensorMovimiento.class);
        startActivity(i);
    }

    public void ElementosDeSeguridad (View view)
    {
        Intent i= new Intent(this,ElementoDeSeguridad.class);
        startActivity(i);
    }

}


