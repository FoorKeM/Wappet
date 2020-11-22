package com.asignatura.wappet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.asignatura.wappet.ui.db.DbHelper;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsFragment extends Fragment {

    private GoogleMap mMap;
    private DbHelper db;

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */

        @Override
        public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;
            ArrayList<Marker>marker = db.getAll();


            /*if(c.moveToFirst()){
                for(int i=0;i<3;i++){
                    nombre[i]=c.getString(c.getColumnIndex("nombre"));
                    descripcion[i]=c.getString(c.getColumnIndex("descripcion"));
                    latitud[i]=Double.parseDouble(c.getString(c.getColumnIndex("latitud")));
                    longitud[i]=Double.parseDouble(c.getString(c.getColumnIndex("longitud")));

                    c.moveToNext();
                }
            }

            LatLng vet1 = new LatLng(-29.921759, -71.235805);
            mMap.addMarker(new MarkerOptions().position(vet1).title("Blanco y violeta")
                    .snippet("Dirección: Eduardo de la barra #660, La Serena, Coquimbo" +
                            "Horario: Lunes a Viernes 10:00 - 23:00"+
                            "Telefono: 9 8383 7766"));

            LatLng vet2 = new LatLng(-29.904477, -71.251779);
            mMap.addMarker(new MarkerOptions().position(vet2).title("Mundo Animal")
                    .snippet("Dirección: Av Guillermo Ulriksen 1693, La Serena, Coquimbo" +
                            "Horario: Lunes a Viernes 10:00 - 23:00"+
                            "Telefono: 9 3168 6065"));

            LatLng vet3 = new LatLng(-29.912675, -71.254872);
            mMap.addMarker(new MarkerOptions().position(vet3).title("SilvaVet")
                    .snippet("Dirección: Gómez Carreño #324, La Serena, Coquimbo" +
                            "Horario: Lunes a Viernes 09:00 - 23:00"+
                            "Telefono: 51 221 2389"));

            LatLng vet4 = new LatLng(-29.914944, -71.251176);
            mMap.addMarker(new MarkerOptions().position(vet4).title("Centro Médico Veterinario La Serena")
                    .snippet("Dirección: Thomas Alba Edison 1530, La Serena, Coquimbo" +
                            "Horario: Lunes a Viernes 08:00 - 21:00"+
                            "Telefono: 51 263 5630")); */

            LatLng city = new LatLng(-29.9045300,-71.2489400);
            //googleMap.moveCamera(CameraUpdateFactory.newLatLng(city));
            float zoomLevel = 16.0f; //This goes up to 21
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(city, zoomLevel));
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}