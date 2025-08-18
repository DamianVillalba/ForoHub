package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.domain.topic.Topic;
import com.aluracursos.forohub.domain.topic.TopicService;
import com.aluracursos.forohub.domain.topic.dto.TopicCreateDTO;
import com.aluracursos.forohub.domain.topic.dto.TopicDTO;
import com.aluracursos.forohub.domain.topic.dto.TopicResponseDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicController {

    @Autowired
    private TopicService service;

    @PostMapping
    @Transactional
    public ResponseEntity<TopicResponseDTO> createTopic(@RequestBody @Valid TopicCreateDTO creationData, UriComponentsBuilder uriComponentsBuilder) {
        //creo el topico nuevo y lo persisto
        Topic newTopic = this.service.createTopic(creationData);

        //genero el url de acceso al topico
        URI url = uriComponentsBuilder
                .path("/topicos/{id}")
                .buildAndExpand(
                        newTopic.getId()).toUri();

        //creo la respuesta para el body con el DTO correspondiente para no exponer la entidad
        TopicResponseDTO response = new TopicResponseDTO(newTopic);

        return ResponseEntity.created(url).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<TopicDTO>> listTopics(@PageableDefault(size = 10, sort = "creationDate") Pageable pageable){
        return ResponseEntity.ok(this.service.findByStatusTrue(pageable)
                .map(TopicDTO::new));
    }
}
