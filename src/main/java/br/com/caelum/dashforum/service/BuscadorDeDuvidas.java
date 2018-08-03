package br.com.caelum.dashforum.service;

import br.com.caelum.dashforum.modelo.Duvidas;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BuscadorDeDuvidas {

    private static final String URL = "https://cursos.alura.com.br/d23hd728h7h8f70fh0f0837fh74387fh3478/forum/sem-respostas";

    public Duvidas buscaDuvidas() {

        RestTemplate template = new RestTemplate();
        return template.getForObject(URL, Duvidas.class);
    }
}
