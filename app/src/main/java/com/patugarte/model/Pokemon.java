package com.patugarte.model;

import com.google.gson.annotations.SerializedName;

import java.util.Comparator;

public class Pokemon {

    @SerializedName("name")
    private String nombre;
    private String url;
    private Integer id;
    private Sprites sprites;
    //private Types types;

    /* POR AHORA NO VOY A USAR ESTOS DATOS
    abilities
    base_experience
    forms
    game_indices
    height
    held_items
    is_default
    location_area_encounters
    moves
    stats	[…]
    weight
    */

    public Pokemon() {}

    public Pokemon(String nombre, String url, Integer id, Sprites sprites, Types types) {
        this.nombre = nombre;
        this.url = url;
        this.id = id;
        this.sprites = sprites;
        //this.types = types;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    /*public Types getTypes() {
        return types;
    }

    public void setTypes(Types types) {
        this.types = types;
    }*/

    public static class SortById implements Comparator<Pokemon> {

        @Override
        public int compare(Pokemon o1, Pokemon o2) {
            return o1.id - o2.id;
        }

    }

}

