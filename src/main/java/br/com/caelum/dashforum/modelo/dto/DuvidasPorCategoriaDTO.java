package br.com.caelum.dashforum.modelo.dto;

import br.com.caelum.dashforum.modelo.DuvidaCategoria;

import java.util.List;
import java.util.stream.Collectors;

public class DuvidasPorCategoriaDTO {
    private List<DuvidaCategoria> duvidaCategorias;

    public DuvidasPorCategoriaDTO(List<DuvidaCategoria> duvidaCategorias) {

        this.duvidaCategorias = duvidaCategorias;
    }

    public List<DuvidaCategoria> getDuvidaCategorias() {
        return duvidaCategorias;
    }

    public int getTotal() {

        List<DuvidaCategoria> lista = duvidaCategorias
                .stream()
                .filter(duvidaCategoria -> !duvidaCategoria.getCategoria().equals(""))
                .filter(duvidaCategoria -> !duvidaCategoria.getCategoria().equals("Business"))
                .collect(Collectors.toList());


        return lista.stream().mapToInt(duvidaCategoria -> duvidaCategoria.getDuvidas().size()).sum();
    }
}
