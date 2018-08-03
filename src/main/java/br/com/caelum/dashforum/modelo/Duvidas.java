package br.com.caelum.dashforum.modelo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Duvidas {

    @JsonProperty("list")
    private List<Duvida> duvidas = new ArrayList<>();


    public List<Duvida> getDuvidas() {
        return duvidas;
    }

    public void setDuvidas(List<Duvida> duvidas) {
        this.duvidas = duvidas;
    }
}
