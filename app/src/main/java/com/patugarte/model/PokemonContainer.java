package com.patugarte.model;

import java.util.List;

public class PokemonContainer {

    private String next;
    private String previous;
    private List<Pokemon> results;

    public PokemonContainer() {}

    public PokemonContainer(String next, String previous, List<Pokemon> results) {
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Pokemon> getResults() {
        return results;
    }

    public void setResults(List<Pokemon> results) {
        this.results = results;
    }
}
