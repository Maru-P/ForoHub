package com.maru.foro.domain.topico.validations.create;

import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maru.foro.domain.topico.dto.CrearTopicoDTO;
import com.maru.foro.domain.topico.repository.TopicoRepository;

@Component
public class TopicoDuplicado implements ValidarTopicoCreado{

    @Autowired
    private TopicoRepository topicoRepository;


    @Override
    public void validate(CrearTopicoDTO data) {
        var topicoDuplicado = topicoRepository.existsByTituloAndMensaje(data.titulo(), data.mensaje());
        if(topicoDuplicado){
            throw new ValidationException("Este topico ya existe. Revisa /topicos/" + topicoRepository.findByTitulo(data.titulo()).getId());

        }
    }
}
