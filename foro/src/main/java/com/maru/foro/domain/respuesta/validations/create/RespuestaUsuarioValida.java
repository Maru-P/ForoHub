package com.maru.foro.domain.respuesta.validations.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maru.foro.domain.respuesta.dto.CrearRespuestaDTO;
import com.maru.foro.domain.usuario.repository.UsuarioRepository;

import jakarta.validation.ValidationException;

@Component
public class RespuestaUsuarioValida implements ValidaRespuestaCreada{

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void validate(CrearRespuestaDTO data) {
        var usuarioExiste = repository.existsById(data.usuarioId());

        if(!usuarioExiste){
            throw new ValidationException("Este usuario no existe");
        }

        var usuarioHabilitado = repository.findById(data.usuarioId()).get().isEnabled();

        if(!usuarioHabilitado){
            throw new ValidationException("Este usuario no esta habilitado");
        }
    }
}
