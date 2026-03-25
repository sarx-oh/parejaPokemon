package com.example.demo.model;

public class pokeEntity {
    private String id;
    private Integer vida1;
    private Integer vida2;

    public pokeEntity() {
    }

    public pokeEntity(String id, Integer vida1, Integer vida2) {
        this.id = id;
        this.vida1 = vida1;
        this.vida2 = vida2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVida1() {
        return vida1;
    }

    public void setVida1(Integer vida1) {
        this.vida1 = vida1;
    }

    public Integer getVida2() {
        return vida2;
    }

    public void setVida2(Integer vida2) {
        this.vida2 = vida2;
    }
}
