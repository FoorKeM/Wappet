package com.asignatura.wappet;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_mascota_extraviada#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_mascota_extraviada extends Fragment {

    EditText nombrep, sexop, fechap, tipop, correop, contactop, descripcionp;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Button buttonsubir;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_mascota_extraviada() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_mascota_extraviada.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_mascota_extraviada newInstance(String param1, String param2) {
        fragment_mascota_extraviada fragment = new fragment_mascota_extraviada();
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
        View vista= inflater.inflate(R.layout.fragment_mascota_extraviada, container, false);

        buttonsubir = (Button) vista.findViewById(R.id.btnagregar);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        nombrep = (EditText) vista.findViewById(R.id.editTextCodigo);
        sexop = (EditText) vista.findViewById(R.id.editTextsexo);
        fechap = (EditText) vista.findViewById(R.id.editTextDate);
        tipop = (EditText) vista.findViewById(R.id.editTextPersona);
        correop = (EditText) vista.findViewById(R.id.editTextProyecto);
        contactop = (EditText) vista.findViewById(R.id.editTextSuma);
        descripcionp = (EditText) vista.findViewById(R.id.editTextDetalle);


        buttonsubir.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                String nombre = nombrep.getText().toString();
                String sexo = sexop.getText().toString();
                String fecha = fechap.getText().toString();
                String tipo = tipop.getText().toString();
                String correo = correop.getText().toString();
                String contacto = contactop.getText().toString();
                String descripcion = descripcionp.getText().toString();

                Map<String, Object> datosUsuario = new HashMap<>();
                datosUsuario.put("nombre",nombre);
                datosUsuario.put("sexo",sexo);
                datosUsuario.put("fecha",fecha);
                datosUsuario.put("tipo",tipo);
                datosUsuario.put("correo",correo);
                datosUsuario.put("contacto",contacto);
                datosUsuario.put("descripcion",descripcion);


                databaseReference.child("Mascota Extraviada").push().setValue(datosUsuario);


                limpiarCajas();
            }
        });
        // Inflate the layout for this fragment
        return vista;
    }

    private void limpiarCajas() {
        nombrep.setText("");
        sexop.setText("");
        fechap.setText("");
        tipop.setText("");
        correop.setText("");
        contactop.setText("+569");
        descripcionp.setText("");
    }

    private void validacion() {
        String nombre = nombrep.getText().toString();
        String sexo = sexop.getText().toString();
        String fecha = fechap.getText().toString();
        String tipo = tipop.getText().toString();
        String correo = correop.getText().toString();
        String contacto = contactop.getText().toString();
        String descripcion = descripcionp.getText().toString();

        if (nombre.equals("")){
            nombrep.setError("Campo Vacio");
        }
        else if (sexo.equals("")){
            sexop.setError("Campo Vacio");
        }
        else if (fecha.equals("")){
            fechap.setError("Campo Vacio");
        }
        else if (tipo.equals("")){
            tipop.setError("Campo Vacio");
        }
        else if (correo.equals("")){
            correop.setError("Campo Vacio");
        }
        else if (contacto.equals("")){
            correop.setError("Campo Vacio");
        }
        else if (descripcion.equals("")){
            descripcionp.setError("Campo Vacio");
        }

    }


}