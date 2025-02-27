package com.maru.foro.domain.curso.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maru.foro.domain.curso.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    Page<Curso> findByActivoTrue(Pageable pageable);
}
