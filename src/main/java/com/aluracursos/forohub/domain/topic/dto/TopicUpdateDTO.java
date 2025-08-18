package com.aluracursos.forohub.domain.topic.dto;

import jakarta.validation.constraints.NotBlank;

//Si bien es la misma estructura que el Create por la regla de negocio
//creo el DTO por si en un futuro esta logica cambia, permitiendo flexibilidad
public record TopicUpdateDTO(
        @NotBlank String title,
        @NotBlank String message,
        @NotBlank String author,
        @NotBlank String course
) {
}
