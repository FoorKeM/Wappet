package com.asignatura.wappet;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class registrar_usuario extends Fragment {

    EditText nombre, apellido, rut, telefono, email, password;
    Button registrarUsuario;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista= inflater.inflate(R.layout.fragment_mascota_veterinario, container, false);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        registrarUsuario = (Button) vista.findViewById(R.id.registrarUsuario);
        nombre = (EditText) vista.findViewById(R.id.name);
        apellido = (EditText) vista.findViewById(R.id.apellido);
        rut = (EditText) vista.findViewById(R.id.rut);
        telefono = (EditText) vista.findViewById(R.id.telefono);
        email = (EditText) vista.findViewById(R.id.username);
        password = (EditText) vista.findViewById(R.id.password);

        registrarUsuario.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                String nombre1 = nombre.getText().toString();
                String apellido1 = apellido.getText().toString();
                String rut1 = rut.getText().toString();
                String telefono1 = telefono.getText().toString();
                String email1 = email.getText().toString();
                String password1 = password.getText().toString();

                Map<String, Object> datosUsuario = new HashMap<>();
                datosUsuario.put("nombre",nombre1);
                datosUsuario.put("apellido",apellido1);
                datosUsuario.put("rut",rut1);
                datosUsuario.put("telefono",telefono1);
                datosUsuario.put("email",email1);
                datosUsuario.put("password",password1);


                databaseReference.child("Usuario").push().setValue(datosUsuario);

                Navigation.findNavController(v).navigate(R.id.loginFragment);
            }
        });

        return vista;
    }
}