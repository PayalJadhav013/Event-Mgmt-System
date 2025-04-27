package com.eventmanagement.controller;

import com.eventmanagement.dto.AttendeeDTO;
import com.eventmanagement.service.AttendeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/attendees")
public class AttendeeController {
    private final AttendeeService attendeeService;

    // Manual constructor injection
    public AttendeeController(AttendeeService attendeeService) {
        this.attendeeService = attendeeService;
    }

    @GetMapping
    public ResponseEntity<List<AttendeeDTO>> getAllAttendees() {
        return ResponseEntity.ok(attendeeService.getAllAttendees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttendeeDTO> getAttendeeById(@PathVariable Long id) {
        return ResponseEntity.ok(attendeeService.getAttendeeById(id));
    }

    @PostMapping
    public ResponseEntity<AttendeeDTO> createAttendee(@Valid @RequestBody AttendeeDTO attendeeDTO) {
        return new ResponseEntity<>(attendeeService.createAttendee(attendeeDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AttendeeDTO> updateAttendee(
            @PathVariable Long id, @Valid @RequestBody AttendeeDTO attendeeDTO) {
        return ResponseEntity.ok(attendeeService.updateAttendee(id, attendeeDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendee(@PathVariable Long id) {
        attendeeService.deleteAttendee(id);
        return ResponseEntity.noContent().build();
    }
}