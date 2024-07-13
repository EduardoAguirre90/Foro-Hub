package com.foro.forohub.service;

import com.foro.forohub.model.Topico;
import com.foro.forohub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Topico> listarTopicos() {
        return topicoRepository.findAll();
    }

    public Optional<Topico> obtenerTopicoPorId(Long id) {
        return topicoRepository.findById(id);
    }

    public void eliminarTopico(Long id) {
        topicoRepository.deleteById(id);
    }

}
