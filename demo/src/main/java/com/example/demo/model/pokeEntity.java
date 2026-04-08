package com.example.demo.model;

public class pokeEntity {
    private String id;
    private String nombre;
    private String imagen;
    private Integer vida;

    public pokeEntity() {
    }

    public pokeEntity(String id, String nombre, String imagen, Integer vida) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.vida = vida;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Integer getVida() {
        return vida;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }
}
