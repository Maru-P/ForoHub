package com.maru.foro.domain.topico.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maru.foro.domain.topico.Estado;
import com.maru.foro.domain.topico.Topico;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    @SuppressWarnings("null")
    Page<Topico> findAll(Pageable pageable);

    Page<Topico> findAllByEstadoIsNot(Estado estado, Pageable pageable);

    Boolean existsByTituloAndMensaje(String titulo, String mensaje);

    Topico findByTitulo(String titulo);
}
