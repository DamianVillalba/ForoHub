package com.aluracursos.forohub.domain.topic.dto;

import com.aluracursos.forohub.domain.topic.Topic;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record TopicDTO(
        Long id,
        String title,
        String message,
        //formateo la fecha para que sea acorde a nuestro estandar
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
        LocalDateTime creationDate,
        Boolean state,
        String author,
        String course
) {
    public TopicDTO(Topic topic) {
        this(
                topic.getId(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getCreationDate(),
                topic.getStatus(),
                topic.getAuthor(),
                topic.getCourse()
        );
    }
}
