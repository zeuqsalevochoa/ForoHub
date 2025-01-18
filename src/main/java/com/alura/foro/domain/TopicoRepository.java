package com.alura.foro.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Topico findByTituloAndMensaje(String titulo, String mensaje);

    Page<Topico> findAll(Pageable pageable);
}
