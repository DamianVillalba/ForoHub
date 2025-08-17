package com.aluracursos.forohub.domain.topic;

import com.aluracursos.forohub.domain.topic.dto.TopicCreateDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "topics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private LocalDateTime creationDate;
    private boolean status;
    private String author; //decido no extender hacia una entidad author ya que extiende lo requerido para el challenge
    private String course; //decido no extender hacia una entidad course ya que extiende lo requerido para el challenge

    public Topic(@Valid TopicCreateDTO creationData) {
        this.title = creationData.title();
        this.message = creationData.message();
        this.creationDate = LocalDateTime.now();
        this.status = true;
        this.author = creationData.author();
        this.course = creationData.course();
    }
}
