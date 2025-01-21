package com.maru.foro.domain.respuesta.validations.update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maru.foro.domain.respuesta.Respuesta;
import com.maru.foro.domain.respuesta.dto.ActualizarRespuestaDTO;
import com.maru.foro.domain.respuesta.repository.RespuestaRepository;
import com.maru.foro.domain.topico.Estado;
import com.maru.foro.domain.topico.repository.TopicoRepository;

import jakarta.validation.ValidationException;

@Component
public class SolucionDuplicada implements ValidarRespuestaActualizada {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validate(ActualizarRespuestaDTO data, Long respuestaId) {
        if (data.solucion()){
            Respuesta respuesta = respuestaRepository.getReferenceById(respuestaId);
            var topicoResuelto = topicoRepository.getReferenceById(respuesta.getTopico().getId());
            if (topicoResuelto.getEstado() == Estado.CLOSED){
                throw new ValidationException("Este topico ya esta solucionado.");
            }
        }
    }
}
