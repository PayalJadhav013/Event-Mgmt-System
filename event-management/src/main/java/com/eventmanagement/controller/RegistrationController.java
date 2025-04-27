// com.eventmanagement.controller.RegistrationController.java
package com.eventmanagement.controller;

import com.eventmanagement.dto.RegistrationDTO;
import com.eventmanagement.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/registrations")
@RequiredArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;
    
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public ResponseEntity<List<RegistrationDTO>> getAllRegistrations() {
        return ResponseEntity.ok(registrationService.getAllRegistrations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistrationDTO> getRegistrationById(@PathVariable Long id) {
        return ResponseEntity.ok(registrationService.getRegistrationById(id));
    }

    @PostMapping
    public ResponseEntity<RegistrationDTO> createRegistration(@RequestBody RegistrationDTO registrationDTO) {
        return new ResponseEntity<>(registrationService.createRegistration(registrationDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegistration(@PathVariable Long id) {
        registrationService.deleteRegistration(id);
        return ResponseEntity.noContent().build();
    }
}