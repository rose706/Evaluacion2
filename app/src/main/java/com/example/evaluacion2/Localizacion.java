package com.example.evaluacion2;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationProvider;
import android.os.Bundle;

import android.util.Log;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class Localizacion implements LocationListener {
   GPS_MAPS mainActivity;
   TextView tvMensaje;
    private Object locationProvider;

    public GPS_MAPS getMainActivity(){
       return mainActivity;
    }

    public void setMainActivity(GPS_MAPS mainActivity, TextView tvMensaje){
       this.mainActivity = mainActivity;
       this.tvMensaje = tvMensaje;

    }

    @Override
    public void onLocationChanged(Location location) {
        String texto = "Mi ubicacion es: \n"
                +"Latitud = " + location.getLatitude() + "\n"
                +"Longitud = " + location.getLongitude();
        tvMensaje.setText(texto);

        mapa(location.getLatitude(),location.getLongitude());
    }

    public void mapa(double lat,double lon){
        FragmentMaps fragment = new FragmentMaps();

        Bundle bundle= new Bundle();
        bundle.putDouble("lat", new Double(lat));
        bundle.putDouble("lon", new Double(lon));
        fragment.setArguments(bundle);

        FragmentManager fragmentManager = getMainActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
      fragmentTransaction.add(R.id.fragment,fragment, null);
        fragmentTransaction.commit();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
       switch (status){

           case LocationProvider
                   .AVAILABLE:
               Log.d("debug","LocationProvider.AVAILABLE");
           break;

           case LocationProvider.OUT_OF_SERVICE:
               Log.d("debug","LocationProvider.OUT_OF_SERVICE");
               break;

           case LocationProvider.TEMPORARILY_UNAVAILABLE:
               Log.d("debug","LocationProvider.TEMPORARILY_UNAVAILABLE");
               break;
       }

    }

    @Override
    public void onProviderEnabled(String provider) {
        tvMensaje.setText("GPS Activado");

    }

    @Override
    public void onProviderDisabled( String provider) {
       tvMensaje.setText("GPS Desactivado");

    }
}
