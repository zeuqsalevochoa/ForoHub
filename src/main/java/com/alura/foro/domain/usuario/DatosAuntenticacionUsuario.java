package com.alura.foro.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DatosAuntenticacionUsuario(
        @NotBlank
        String login,
        @NotBlank
        String clave
) {
}
