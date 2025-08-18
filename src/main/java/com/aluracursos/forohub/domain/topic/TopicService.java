package com.aluracursos.forohub.domain.topic;

import com.aluracursos.forohub.domain.topic.dto.TopicCreateDTO;
import com.aluracursos.forohub.domain.topic.dto.TopicDetailDTO;
import com.aluracursos.forohub.domain.topic.dto.TopicUpdateDTO;
import com.aluracursos.forohub.infra.exception.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<Topic> findByStatusTrue(Pageable pageable) {
        return this.repository.findByStatusTrue(pageable);
    }

    public Topic getTopicById(Long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tópico no encontrado con ID: " + id));
    }

    public Topic updateTopicById(Long id, @Valid TopicUpdateDTO updateData) {
        Topic topic = this.getTopicById(id);
        topic.updateTopic(updateData);
        return topic;
    }

    public void deleteTopicById(Long id) {
        if (!this.repository.existsById(id)) {
            throw new ResourceNotFoundException("Tópico no encontrado con ID: " + id);
        }
        this.repository.deleteById(id);
    }
}
