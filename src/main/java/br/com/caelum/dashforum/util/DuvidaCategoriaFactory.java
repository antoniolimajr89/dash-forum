package br.com.caelum.dashforum.util;

import br.com.caelum.dashforum.modelo.Duvida;
import br.com.caelum.dashforum.modelo.DuvidaCategoria;
import br.com.caelum.dashforum.modelo.Duvidas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DuvidaCategoriaFactory {

    public List<DuvidaCategoria> criaAtravesDas(Duvidas duvidas) {

        List<Duvida> duvidasDaAlura = pegaTodasDuvidasOrdenadasPorCategoria(duvidas);

        List<DuvidaCategoria> ordenadas = new ArrayList<>();

        List<Duvida> duvidasPorCategoria = new ArrayList<>();

        Duvida atual = duvidasDaAlura.get(0);

        for (Duvida duvida : duvidasDaAlura) {

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

    private List<Duvida> pegaTodasDuvidasOrdenadasPorCategoria(Duvidas duvidas) {
        List<Duvida> duvidasDaAlura = duvidas.getDuvidas();

        duvidasDaAlura.sort(Comparator.comparing(Duvida::getCategoria));
        return duvidasDaAlura;
    }


    private boolean categoriaMudou(Duvida atual, Duvida duvida) {
        return !atual.getCategoria().equals(duvida.getCategoria());
    }

    private void adicionaNasOrdenadasUmaNovaCategoria(List<DuvidaCategoria> ordenadas, List<Duvida> duvidasPorCategoria) {
        String categoria = duvidasPorCategoria.get(0).getCategoria();

        DuvidaCategoria duvidaCategoria = new DuvidaCategoria(categoria, duvidasPorCategoria);
        ordenadas.add(duvidaCategoria);
    }


}
