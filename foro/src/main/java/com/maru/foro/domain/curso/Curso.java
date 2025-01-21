package com.maru.foro.domain.curso;

import com.maru.foro.domain.curso.dto.ActualizarCursoDTO;
import com.maru.foro.domain.curso.dto.CrearCursoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "cursos")
@Table(name = "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private Boolean activo;

    public Curso(CrearCursoDTO crearCursoDTO) {
        this.nombre = crearCursoDTO.nombre();
        this.categoria = crearCursoDTO.categoria();
        this.activo = true;
    }

    public void actualizarCurso(ActualizarCursoDTO actualizarCursoDTO) {
        if (actualizarCursoDTO.nombre() != null) {
            this.nombre = actualizarCursoDTO.nombre();
        }
        if (actualizarCursoDTO.categoria() != null) {
            this.categoria = actualizarCursoDTO.categoria(); 
        }
        if (actualizarCursoDTO.activo() != null) {
            this.activo = actualizarCursoDTO.activo();    
        }
    }

    public void eliminarCurso(){
        this.activo = false;
    }
}
