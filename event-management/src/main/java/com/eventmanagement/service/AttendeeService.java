// com.eventmanagement.service.AttendeeService.java
package com.eventmanagement.service;

import com.eventmanagement.dto.AttendeeDTO;
import com.eventmanagement.exception.ResourceNotFoundException;
import com.eventmanagement.model.Attendee;
import com.eventmanagement.repository.AttendeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendeeService {
    private final AttendeeRepository attendeeRepository;
    private final ModelMapper modelMapper;
    
    public AttendeeService(AttendeeRepository attendeeRepository, ModelMapper modelMapper) {
        this.attendeeRepository = attendeeRepository;
        this.modelMapper = modelMapper;
    }

    public List<AttendeeDTO> getAllAttendees() {
        return attendeeRepository.findAll().stream()
                .map(attendee -> modelMapper.map(attendee, AttendeeDTO.class))
                .collect(Collectors.toList());
    }

    public AttendeeDTO getAttendeeById(Long id) {
        Attendee attendee = attendeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Attendee not found with id: " + id));
        return modelMapper.map(attendee, AttendeeDTO.class);
    }

    public AttendeeDTO createAttendee(AttendeeDTO attendeeDTO) {
        Attendee attendee = modelMapper.map(attendeeDTO, Attendee.class);
        Attendee savedAttendee = attendeeRepository.save(attendee);
        return modelMapper.map(savedAttendee, AttendeeDTO.class);
    }

    public AttendeeDTO updateAttendee(Long id, AttendeeDTO attendeeDTO) {
        Attendee existingAttendee = attendeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Attendee not found with id: " + id));
        
        modelMapper.map(attendeeDTO, existingAttendee);
        Attendee updatedAttendee = attendeeRepository.save(existingAttendee);
        return modelMapper.map(updatedAttendee, AttendeeDTO.class);
    }

    public void deleteAttendee(Long id) {
        if (!attendeeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Attendee not found with id: " + id);
        }
        attendeeRepository.deleteById(id);
    }
}