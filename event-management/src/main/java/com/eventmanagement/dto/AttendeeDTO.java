// com.eventmanagement.dto.AttendeeDTO.java
package com.eventmanagement.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class AttendeeDTO {
    private Long id;
    
    @NotBlank
    @Size(max = 100)
    private String name;
    
    @NotBlank
    @Email
    private String email;
    
    @NotBlank
    @Pattern(regexp = "^[0-9]{10}$")
    private String phone;
}