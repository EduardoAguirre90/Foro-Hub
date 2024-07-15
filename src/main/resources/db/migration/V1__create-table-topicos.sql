CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    mensaje TEXT NOT NULL,
    fechaCreacion TIMESTAMP,
    estado VARCHAR(20),
    autor VARCHAR(100) NOT NULL,
    curso VARCHAR(100) NOT NULL

    PRIMARY KEY(id)
);
