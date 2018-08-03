package br.com.caelum.dashforum.service;

import br.com.caelum.dashforum.modelo.DuvidaCategoria;
import br.com.caelum.dashforum.modelo.dto.ListaDeDuvidasDTO;
import br.com.caelum.dashforum.modelo.dto.DuvidasPorCategoriaDTO;
import br.com.caelum.dashforum.util.DuvidaCategoriaFactory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DuvidaCategoriaService {

    private final BuscadorDeDuvidas buscadorDeDuvidas;
    private final DuvidaCategoriaFactory factory;

    @Autowired
    public DuvidaCategoriaService(BuscadorDeDuvidas buscadorDeDuvidas, DuvidaCategoriaFactory factory) {
        this.buscadorDeDuvidas = buscadorDeDuvidas;
        this.factory = factory;
    }


    public DuvidasPorCategoriaDTO listaDeDuvidasPorCategoria() {

        ListaDeDuvidasDTO duvidas = buscadorDeDuvidas.buscaDuvidas();

        List<DuvidaCategoria> duvidaCategorias = factory.criaAtravesDas(duvidas);

        return new DuvidasPorCategoriaDTO(duvidaCategorias);
    }
}
