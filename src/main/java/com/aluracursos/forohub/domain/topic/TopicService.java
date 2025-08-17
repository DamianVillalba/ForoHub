package com.aluracursos.forohub.domain.topic;

import com.aluracursos.forohub.domain.topic.dto.TopicCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private TopicRepository repository;

    public Topic createTopic(TopicCreateDTO data) {
        // Convierte el DTO a la entidad
        Topic newTopic = new Topic(data);

        return this.repository.save(newTopic);
    }
}
