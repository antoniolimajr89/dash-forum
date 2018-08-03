package br.com.caelum.dashforum.controller;

import br.com.caelum.dashforum.modelo.DuvidaCategoria;
import br.com.caelum.dashforum.service.DuvidaCategoriaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DuvidaController {

    private final DuvidaCategoriaService service;

    @Autowired
    public DuvidaController(DuvidaCategoriaService service) {
        this.service = service;
    }


    @GetMapping("/dashboard")
    public ModelAndView vaiParaDashboard() {
        List<DuvidaCategoria> lista = service.listaDeDuvidasPorCategoria();

        ModelAndView modelAndView = new ModelAndView("dashboard/principal");

        modelAndView.addObject("lista", lista);

        return modelAndView;
    }
}
