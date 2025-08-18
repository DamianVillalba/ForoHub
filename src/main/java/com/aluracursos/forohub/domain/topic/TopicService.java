package com.aluracursos.forohub.domain.topic;

import com.aluracursos.forohub.domain.topic.dto.TopicCreateDTO;
import com.aluracursos.forohub.domain.topic.dto.TopicDetailDTO;
import com.aluracursos.forohub.infra.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository repository;

    public Topic createTopic(TopicCreateDTO data) {
        // Convierte el DTO a la entidad
        Topic newTopic = new Topic(data);

        return this.repository.save(newTopic);
    }

    public Page<Topic> findByStatusTrue(Pageable pageable) {
        return this.repository.findByStatusTrue(pageable);
    }

    public TopicDetailDTO getTopicById(Long id) {
        Topic topic = this.repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tópico no encontrado con ID: " + id));
        return new TopicDetailDTO(topic);
    }
}
