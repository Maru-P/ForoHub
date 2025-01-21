package com.maru.foro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.maru.foro.domain.curso.Curso;
import com.maru.foro.domain.curso.dto.ActualizarCursoDTO;
import com.maru.foro.domain.curso.dto.CrearCursoDTO;
import com.maru.foro.domain.curso.dto.DetalleCursoDTO;
import com.maru.foro.domain.curso.repository.CursoRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cursos")
@SecurityRequirement(name = "bearer")
@Tag(name = "Curso", description = "API para administrar los cursos")
public class CursoController {
    @Autowired
    private CursoRepository repository;

    @PostMapping
    @Transactional
    @Operation(summary = "Registrar curso", description = "Permite registrar un curso")
    public ResponseEntity<DetalleCursoDTO> crearTopico(@RequestBody @Valid CrearCursoDTO crearCursoDTO,
                                                       UriComponentsBuilder uriBuilder){
        Curso curso = new Curso(crearCursoDTO);
        repository.save(curso);
        var uri = uriBuilder.path("/cursos/{i}").buildAndExpand(curso.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalleCursoDTO(curso));

    }

    @GetMapping("/all")
    @Operation(summary = "Lee todos los cursos independientemente de su estado")
    public ResponseEntity<Page<DetalleCursoDTO>> listarCursos(@PageableDefault(size = 5, sort = {"id"}) Pageable pageable){
        var pagina = repository.findAll(pageable).map(DetalleCursoDTO::new);
        return ResponseEntity.ok(pagina);
    }

    @GetMapping
    @Operation(summary = "Lista de cursos activos")
    public ResponseEntity<Page<DetalleCursoDTO>> listarCursosActivos(@PageableDefault(size = 5, sort = {"id"}) Pageable pageable){
        var pagina = repository.findByActivoTrue(pageable).map(DetalleCursoDTO::new);
        return ResponseEntity.ok(pagina);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Lee un solo curso por su ID")
    public ResponseEntity<DetalleCursoDTO> ListarUnCurso(@PathVariable Long id){
        Curso curso = repository.getReferenceById(id);
        var datosDelCurso = new DetalleCursoDTO(
                curso.getId(),
                curso.getNombre(),
                curso.getCategoria(),
                curso.getActivo()
        );
        return ResponseEntity.ok(datosDelCurso);
    }

    @PutMapping("/{id}")
    @Transactional
    @Operation(summary = "Actualiza el nombre, la categoría o el estado de un curso")
    public ResponseEntity<DetalleCursoDTO> actualizarCurso(@RequestBody @Valid ActualizarCursoDTO actualizarCursoDTO, @PathVariable Long id){

        Curso curso = repository.getReferenceById(id);

        curso.actualizarCurso(actualizarCursoDTO);

        var datosDelCurso = new DetalleCursoDTO(
                curso.getId(),
                curso.getNombre(),
                curso.getCategoria(),
                curso.getActivo()
        );
        return ResponseEntity.ok(datosDelCurso);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Operation(summary = "Elimina un curso")
    public ResponseEntity<?> eliminarCurso(@PathVariable Long id){
        Curso curso = repository.getReferenceById(id);
        curso.eliminarCurso();
        return ResponseEntity.noContent().build();
    }
}
