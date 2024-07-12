package com.foro.forohub.controller;

import com.foro.forohub.model.Topico;
import com.foro.forohub.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
