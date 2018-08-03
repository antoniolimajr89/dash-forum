package br.com.caelum.dashforum.modelo;

import br.com.caelum.dashforum.modelo.dto.DuvidaDTO;

import java.util.List;

public class DuvidaCategoria {

    private String categoria;
    private List<DuvidaDTO> duvidas;
    private DuvidaStatus status;

    public DuvidaCategoria(String categoria, List<DuvidaDTO> duvidas) {
        this.categoria = categoria;
        this.duvidas = duvidas;
        this.status = statusDas(duvidas);
    }

    public List<DuvidaDTO> getDuvidas() {
        return duvidas;
    }

    public DuvidaStatus getStatus() {
        return status;
    }

    public String getCategoria() {
        return categoria;
    }

    private DuvidaStatus statusDas(List<DuvidaDTO> duvidas) {

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
}
