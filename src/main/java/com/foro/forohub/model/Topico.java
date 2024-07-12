package com.foro.forohub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Table(name = "topico")
    @Entity(name = "Topicos")
    @Getter
    
    public class Topico {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotEmpty
        private String titulo;

        @NotEmpty
        private String mensaje;

        @NotNull
        private LocalDateTime fechaCreacion = LocalDateTime.now();

        private String estado = "abierto";

        @NotEmpty
        private String autor;

        @NotEmpty
        private String curso;

}
