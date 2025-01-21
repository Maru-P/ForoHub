package com.maru.foro.domain.respuesta.validations.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maru.foro.domain.respuesta.dto.CrearRespuestaDTO;
import com.maru.foro.domain.topico.Estado;
import com.maru.foro.domain.topico.repository.TopicoRepository;

import jakarta.validation.ValidationException;

@Component
public class RespuestaTopicoValida implements ValidaRespuestaCreada{

    @Autowired
    private TopicoRepository repository;

    @Override
    public void validate(CrearRespuestaDTO data) {
        var topicoExiste = repository.existsById(data.topicoId());

        if (!topicoExiste){
            throw new ValidationException("Este topico no existe.");
        }

        var topicoAbierto = repository.findById(data.topicoId()).get().getEstado();

        if(topicoAbierto != Estado.OPEN){
            throw new ValidationException("Este topico no esta abierto.");
        }

    }
}
