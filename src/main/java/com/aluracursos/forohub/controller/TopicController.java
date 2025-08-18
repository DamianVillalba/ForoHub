package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.domain.topic.Topic;
import com.aluracursos.forohub.domain.topic.TopicService;
import com.aluracursos.forohub.domain.topic.dto.*;
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
@RequestMapping("/v1/topicos")
public class TopicController {

    @Autowired
    private TopicService service;

    @PostMapping
    @Transactional
    public ResponseEntity<TopicDetailDTO> createTopic(@RequestBody @Valid TopicCreateDTO creationData, UriComponentsBuilder uriComponentsBuilder) {
        //creo el topico nuevo y lo persisto
        Topic newTopic = this.service.createTopic(creationData);

        //genero el url de acceso al topico
        URI url = uriComponentsBuilder
                .path("/topicos/{id}")
                .buildAndExpand(
                        newTopic.getId()).toUri();

        //creo la respuesta para el body con el DTO correspondiente para no exponer la entidad
        TopicDetailDTO response = new TopicDetailDTO(newTopic);

        return ResponseEntity.created(url).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<TopicDetailDTO>> listTopics(@PageableDefault(size = 10, sort = "creationDate") Pageable pageable){
        Page<TopicDetailDTO> page = this.service.findByStatusTrue(pageable)
                .map(TopicDetailDTO::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicDetailDTO> detailTopic(@PathVariable Long id){
        TopicDetailDTO topicDetail = new TopicDetailDTO(this.service.getTopicById(id));
        return ResponseEntity.ok(topicDetail);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicDetailDTO> updateTopic(@PathVariable Long id, @RequestBody @Valid TopicUpdateDTO updateData){
        TopicDetailDTO topicDetail = new TopicDetailDTO(this.service.updateTopicById(id, updateData));
        return ResponseEntity.ok(topicDetail);
    }
}
