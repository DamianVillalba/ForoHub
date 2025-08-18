package com.aluracursos.forohub.domain.topic;

import com.aluracursos.forohub.domain.topic.dto.TopicCreateDTO;
import com.aluracursos.forohub.domain.topic.dto.TopicUpdateDTO;
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
    private Boolean status;
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

    public void updateTopic(@Valid TopicUpdateDTO updateData) {
        //Como los datos son obligatorios, no hay necesidad de corroborar Null.
        this.title = updateData.title();
        this.message = updateData.message();
        this.author = updateData.author();
        this.course = updateData.course();
    }
}
