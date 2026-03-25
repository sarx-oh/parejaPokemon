package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.model.pokeEntity;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class PokeConsultaService {
    public List<pokeEntity> obtenerPokemons() {
        try {
            Firestore db = FirestoreClient.getFirestore();
            QuerySnapshot snapshot = db.collection("pokemones").get().get();

            if (snapshot.getDocuments().isEmpty()) {
                snapshot = db.collection("pokemons").get().get();
            }

            List<pokeEntity> pokemons = new ArrayList<>();

            for (DocumentSnapshot document : snapshot.getDocuments()) {
                Map<String, Object> data = document.getData();

                if (data == null) {
                    continue;
                }

                String id = document.getId();
                Integer vida1 = obtenerEntero(data.get("vida1"));
                Integer vida2 = obtenerEntero(data.get("vida2"));

                pokemons.add(new pokeEntity(id, vida1, vida2));
            }

            return pokemons;
        } catch (Exception e) {
            throw new RuntimeException("Error al consultar los pokemons en Firebase", e);
        }
    }

    private Integer obtenerEntero(Object valor) {
        if (valor instanceof Number numero) {
            return numero.intValue();
        }

        if (valor == null) {
            return 0;
        }

        return Integer.parseInt(String.valueOf(valor));
    }
}
