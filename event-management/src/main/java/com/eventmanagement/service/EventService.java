// com.eventmanagement.service.EventService.java
package com.eventmanagement.service;

import com.eventmanagement.dto.EventDTO;
import com.eventmanagement.exception.ResourceNotFoundException;
import com.eventmanagement.model.Event;
import com.eventmanagement.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final ModelMapper modelMapper;
    
    public EventService(EventRepository eventRepository, ModelMapper modelMapper) {
        this.eventRepository = eventRepository;
        this.modelMapper = modelMapper;
    }

    public List<EventDTO> getAllEvents() {
        return eventRepository.findAll().stream()
                .map(event -> modelMapper.map(event, EventDTO.class))
                .collect(Collectors.toList());
    }

    public EventDTO getEventById(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + id));
        return modelMapper.map(event, EventDTO.class);
    }

    public EventDTO createEvent(EventDTO eventDTO) {
        Event event = modelMapper.map(eventDTO, Event.class);
        Event savedEvent = eventRepository.save(event);
        return modelMapper.map(savedEvent, EventDTO.class);
    }

    public EventDTO updateEvent(Long id, EventDTO eventDTO) {
        Event existingEvent = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + id));
        
        modelMapper.map(eventDTO, existingEvent);
        Event updatedEvent = eventRepository.save(existingEvent);
        return modelMapper.map(updatedEvent, EventDTO.class);
    }

    public void deleteEvent(Long id) {
        if (!eventRepository.existsById(id)) {
            throw new ResourceNotFoundException("Event not found with id: " + id);
        }
        eventRepository.deleteById(id);
    }
}