package com.example.evaluacion2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

public class ElementoDeSeguridad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elemento_de_seguridad);

        if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) == getPackageManager().PERMISSION_GRANTED){
            Toast.makeText(getApplicationContext(), "Permiso de usar la camara aceptado",Toast.LENGTH_SHORT).show();
        }else{

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);

            Toast.makeText(getApplicationContext(), "Permiso de usar la camara no aceptado",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 1:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "Permiso de usar la camara aceptado",Toast.LENGTH_SHORT).show();
                }else{

                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);

                    Toast.makeText(getApplicationContext(), "Permiso de usar la camara no aceptado",Toast.LENGTH_SHORT).show();
                }
        }
    }
}