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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_registrar_usuario#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_registrar_usuario extends Fragment {

    EditText nombre, apellido, rut, telefono, email, password;
    Button registrarUsuario;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_registrar_usuario() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_registrar_usuario.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_registrar_usuario newInstance(String param1, String param2) {
        fragment_registrar_usuario fragment = new fragment_registrar_usuario();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista= inflater.inflate(R.layout.fragment_registrar_usuario3, container, false);

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