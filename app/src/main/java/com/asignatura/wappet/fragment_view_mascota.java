package com.asignatura.wappet;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class fragment_view_mascota extends Fragment{

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    RecyclerView recyclerView;
    AdaptadorMascotasE adaptadorMascotasE;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_view_mascota, container, false);
        recyclerView=(RecyclerView)root.findViewById(R.id.vermascota);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<ElementMascota> options =
                new FirebaseRecyclerOptions.Builder<ElementMascota>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Mascota Extraviada"), ElementMascota.class)
                        .build();

        adaptadorMascotasE = new AdaptadorMascotasE(options);
        recyclerView.setAdapter(adaptadorMascotasE);
        return root;
    }

    public void onStart(){
        super.onStart();
        adaptadorMascotasE.startListening();
    }

    public void onStop(){
        super.onStop();
        adaptadorMascotasE.startListening();
    }

}