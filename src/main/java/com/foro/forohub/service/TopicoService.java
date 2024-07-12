package com.foro.forohub.service;

import com.foro.forohub.model.Topico;
import com.foro.forohub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;

    public Topico guardarTopico(Topico topico) {
        return topicoRepository.save(topico);
    }

    public boolean existeTopico(String titulo, String mensaje) {
        return topicoRepository.existsByTituloAndMensaje(titulo, mensaje);
    }

}
