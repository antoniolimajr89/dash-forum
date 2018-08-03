package br.com.caelum.dashforum.util;

import br.com.caelum.dashforum.modelo.dto.DuvidaDTO;
import br.com.caelum.dashforum.modelo.DuvidaCategoria;
import br.com.caelum.dashforum.modelo.dto.ListaDeDuvidasDTO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DuvidaCategoriaFactory {

    public List<DuvidaCategoria> criaAtravesDas(ListaDeDuvidasDTO duvidas) {

        List<DuvidaDTO> duvidasDaAlura = pegaTodasDuvidasOrdenadasPorCategoria(duvidas);

        List<DuvidaCategoria> ordenadas = new ArrayList<>();

        List<DuvidaDTO> duvidasPorCategoria = new ArrayList<>();

        DuvidaDTO atual = duvidasDaAlura.get(0);

        for (DuvidaDTO duvida : duvidasDaAlura) {

            if (categoriaMudou(atual, duvida)) {

                adicionaNasOrdenadasUmaNovaCategoria(ordenadas, duvidasPorCategoria);

                atual = duvida;

                duvidasPorCategoria = new ArrayList<>();

            }

            duvidasPorCategoria.add(duvida);
        }

        adicionaNasOrdenadasUmaNovaCategoria(ordenadas, duvidasPorCategoria);

        return ordenadas;

    }

    private List<DuvidaDTO> pegaTodasDuvidasOrdenadasPorCategoria(ListaDeDuvidasDTO duvidas) {
        List<DuvidaDTO> duvidasDaAlura = duvidas.getDuvidas();

        duvidasDaAlura.sort(Comparator.comparing(DuvidaDTO::getCategoria));
        return duvidasDaAlura;
    }


    private boolean categoriaMudou(DuvidaDTO atual, DuvidaDTO duvida) {
        return !atual.getCategoria().equals(duvida.getCategoria());
    }

    private void adicionaNasOrdenadasUmaNovaCategoria(List<DuvidaCategoria> ordenadas, List<DuvidaDTO> duvidasPorCategoria) {
        String categoria = duvidasPorCategoria.get(0).getCategoria();

        DuvidaCategoria duvidaCategoria = new DuvidaCategoria(categoria, duvidasPorCategoria);
        ordenadas.add(duvidaCategoria);
    }


}
