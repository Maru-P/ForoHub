package com.maru.foro.domain.usuario.validations.update;

import com.maru.foro.domain.usuario.dto.ActualizarUsuarioDTO;

public interface ValidarActualizarUsuario {
    void validate(ActualizarUsuarioDTO data);
}
