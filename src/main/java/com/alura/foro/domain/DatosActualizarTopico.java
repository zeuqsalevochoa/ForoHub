package com.alura.foro.domain;

import jakarta.validation.constraints.NotBlank;

public record DatosActualizarTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        String curso
) {
}
