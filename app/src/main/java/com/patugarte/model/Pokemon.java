package com.patugarte.model;

public class Pokemon {

    private String nombre;
    private String imagen;
    private String tipo;

    public Pokemon() {}

    public Pokemon(String nombre, String imagen, String tipo) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.tipo = tipo;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
