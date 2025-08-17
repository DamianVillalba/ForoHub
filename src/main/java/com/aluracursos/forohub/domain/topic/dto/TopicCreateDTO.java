package com.aluracursos.forohub.domain.topic.dto;

import jakarta.validation.constraints.NotBlank;

public record TopicCreateDTO(
        @NotBlank String title,
        @NotBlank String message,
        @NotBlank String author,
        @NotBlank String course
) {
}
