package com.foro.forohub.controller;

import com.foro.forohub.model.Topico;
import com.foro.forohub.service.TopicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
    @RequestMapping("/topicos")
    @Validated
    public class TopicoController {

        @Autowired
        private TopicoService topicoService;

        @PostMapping
//        public void RegistrarTopico(@RequestBody String parametero){
//            System.out.println("el request llega correctamente");
//            System.out.println(parametero);
        public ResponseEntity<Topico> registrarTopico(@RequestBody Topico topico) {
            if (topicoService.existeTopico(topico.getTitulo(), topico.getMensaje())) {
                return ResponseEntity.badRequest().build();
            }
            Topico nuevoTopico = topicoService.guardarTopico(topico);
            return ResponseEntity.ok(nuevoTopico);
        }

        @GetMapping
        public List<Topico> listarTopicos() {
            return topicoService.listarTopicos();
        }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> obtenerTopico(@PathVariable Long id) {
        Optional<Topico> topico = topicoService.obtenerTopicoPorId(id);
        return topico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<Topico> actualizarTopico(@PathVariable Long id, @Valid @RequestBody Topico topico) {
        if (!topicoService.obtenerTopicoPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        topico.setId(id);
        Topico topicoActualizado = topicoService.guardarTopico(topico);
        return ResponseEntity.ok(topicoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        if (!topicoService.obtenerTopicoPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        topicoService.eliminarTopico(id);
        return ResponseEntity.noContent().build();
    }git a


}
