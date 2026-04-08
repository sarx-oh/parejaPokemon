package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.pokeEntity;
import com.example.demo.services.FirebaseService;
import com.example.demo.services.PokeConsultaService;

@RestController
public class TestDBController {
    private final FirebaseService firebaseService;
    private final PokeConsultaService pokeConsultaService;

    public TestDBController(FirebaseService firebaseService, PokeConsultaService pokeConsultaService) {
        this.firebaseService = firebaseService;
        this.pokeConsultaService = pokeConsultaService;
    }

    @GetMapping("/firebase-test")
    public String testFirebase() {

        firebaseService.guardarDato();
        return "Dato enviado a Firebase";
    }

    @GetMapping("/pokemons")
    public List<pokeEntity> getPokemons() {
        return pokeConsultaService.obtenerPokemons();
    }
}
