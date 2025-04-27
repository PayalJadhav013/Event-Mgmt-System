// com.eventmanagement.service.RegistrationService.java
package com.eventmanagement.service;

import com.eventmanagement.dto.RegistrationDTO;
import com.eventmanagement.exception.ResourceNotFoundException;
import com.eventmanagement.model.*;
import com.eventmanagement.repository.*;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationService {
    private final RegistrationRepository registrationRepository;
    private final EventRepository eventRepository;
    private final AttendeeRepository attendeeRepository;
    
    public RegistrationService(RegistrationRepository registrationRepository, 
                             EventRepository eventRepository, 
                             AttendeeRepository attendeeRepository) {
        this.registrationRepository = registrationRepository;
        this.eventRepository = eventRepository;
        this.attendeeRepository = attendeeRepository;
    }

    public List<RegistrationDTO> getAllRegistrations() {
        return registrationRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public RegistrationDTO getRegistrationById(Long id) {
        Registration registration = registrationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Registration not found with id: " + id));
        return convertToDTO(registration);
    }

    public RegistrationDTO createRegistration(RegistrationDTO registrationDTO) {
        Event event = eventRepository.findById(registrationDTO.getEventId())
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + registrationDTO.getEventId()));
        
        Attendee attendee = attendeeRepository.findById(registrationDTO.getAttendeeId())
                .orElseThrow(() -> new ResourceNotFoundException("Attendee not found with id: " + registrationDTO.getAttendeeId()));
        
        // Check if event has capacity
        if (event.getRegistrations().size() >= event.getCapacity()) {
            throw new IllegalStateException("Event is already at full capacity");
        }
        
        Registration registration = new Registration();
        registration.setEvent(event);
        registration.setAttendee(attendee);
        registration.setRegistrationDate(LocalDateTime.now());
        
        Registration savedRegistration = registrationRepository.save(registration);
        return convertToDTO(savedRegistration);
    }

    public void deleteRegistration(Long id) {
        if (!registrationRepository.existsById(id)) {
            throw new ResourceNotFoundException("Registration not found with id: " + id);
        }
        registrationRepository.deleteById(id);
    }

    private RegistrationDTO convertToDTO(Registration registration) {
        RegistrationDTO dto = new RegistrationDTO();
        dto.setId(registration.getId());
        dto.setEventId(registration.getEvent().getId());
        dto.setAttendeeId(registration.getAttendee().getId());
        dto.setEventName(registration.getEvent().getName());
        dto.setAttendeeName(registration.getAttendee().getName());
        dto.setRegistrationDate(registration.getRegistrationDate().toString());
        return dto;
    }
}