package com.maru.foro.domain.usuario.dto;

import com.maru.foro.domain.usuario.Role;

public record ActualizarUsuarioDTO(
        String password,
        Role role,
        String nombre,
        String apellido,
        String email,
        Boolean enabled
) {
}
