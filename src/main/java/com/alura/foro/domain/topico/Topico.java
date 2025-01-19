package com.alura.foro.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

//@NoArgsConstructor
//@Getter
@AllArgsConstructor
@Entity
@Table(name = "topicos")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private Boolean status;
    private String autor;
    private String curso;

    Topico(){

    }

    public Topico(DatosRegistroTopico datosTopico) {
        this.titulo = datosTopico.titulo();
        this.mensaje = datosTopico.mensaje();
        fechaCreacion = LocalDateTime.now();
        this.status = true;
        this.autor = datosTopico.autor();
        this.curso = datosTopico.curso();
    }

    public void actualizarTopico(DatosActualizarTopico datosTopico) {
        this.titulo = datosTopico.titulo();
        this.mensaje = datosTopico.mensaje();
        this.curso = datosTopico.curso();
        this.fechaCreacion = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getAutor() {
        return autor;
    }

    public String getCurso() {
        return curso;
    }
}
