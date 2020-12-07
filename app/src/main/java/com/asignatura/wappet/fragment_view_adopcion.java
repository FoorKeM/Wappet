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
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_view_adopcion#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_view_adopcion extends Fragment {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    RecyclerView recyclerView;
    AdaptadorMascotasE adaptadorMascotasE;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_view_adopcion, container, false);
        recyclerView=(RecyclerView)root.findViewById(R.id.veradopcion);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<ElementMascota> options =
                new FirebaseRecyclerOptions.Builder<ElementMascota>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Mascota Adopcion"), ElementMascota.class)
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