package br.com.caelum.dashforum.modelo;

import java.util.List;

public class DuvidaCategoria {

    private String categoria;
    private List<Duvida> duvidas;
    private DuvidaStatus status;

    public DuvidaCategoria(String categoria, List<Duvida> duvidas) {
        this.categoria = categoria;
        this.duvidas = duvidas;
        this.status = statusDas(duvidas);
    }

    public List<Duvida> getDuvidas() {
        return duvidas;
    }

    public DuvidaStatus getStatus() {
        return status;
    }

    private DuvidaStatus statusDas(List<Duvida> duvidas) {

        int tamanho = duvidas.size();
        if (tamanho <= 5)
            return DuvidaStatus.SUSSA;
        if (tamanho <= 10)
            return DuvidaStatus.TRANQUILO;
        if (tamanho <= 15)
            return DuvidaStatus.SE_LIGA;
        else
            return DuvidaStatus.DEU_RUIM;
    }

    public String getCategoria() {
        return categoria;
    }
}
