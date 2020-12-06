package com.asignatura.wappet;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class fragment_view_mascota extends Fragment implements AdapterMascota.OnNoteListener{

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    public List<ElementMascota> listaMascota;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_view_mascota, container, false);
        init();

        return root;
    }

    private void init() {

    }

    @Override
    public void onNoteClick(int position) {
        db.collection("Mascota Extraviada")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        List<ElementMascota> lista;
                        lista = new ArrayList<ElementMascota>();
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                lista.add(new ElementMascota(document.getData().get("nombre").toString(),document.getData().get("sexo").toString(),document.getData().get("tipo").toString(),document.getData().get("contacto").toString(),document.getData().get("correo").toString(),document.getData().get("descripcion").toString(),document.getData().get("fecha").toString()));
                            }
                            if (lista.size() != 0){

                                Mostrar(lista);
                            }

                        }
                    }
                });
    }
    public void Mostrar(List<ElementMascota> lista){

        AdapterMascota listAdapter = new AdapterMascota(lista,getContext(),this);
        RecyclerView recyclerView = getView().findViewById(R.id.vermascota);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(listAdapter);
        listaMascota = lista;
    }
}