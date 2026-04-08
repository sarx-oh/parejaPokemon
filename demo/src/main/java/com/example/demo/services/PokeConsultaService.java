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
                String nombre = obtenerTexto(data.get("nombre"));
                String imagen = obtenerTexto(data.get("imagen"));
                Integer vida = obtenerEntero(data.get("vida"));

                pokemons.add(new pokeEntity(id, nombre, imagen, vida));
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

    private String obtenerTexto(Object valor) {
        if (valor == null) {
            return "";
        }

        return String.valueOf(valor);
    }
}
