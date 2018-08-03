package br.com.caelum.dashforum.modelo.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListaDeDuvidasDTO {

    @JsonProperty("list")
    private List<DuvidaDTO> duvidas = new ArrayList<>();


    public List<DuvidaDTO> getDuvidas() {
        return duvidas;
    }

    public void setDuvidas(List<DuvidaDTO> duvidas) {
        this.duvidas = duvidas;
    }
}
