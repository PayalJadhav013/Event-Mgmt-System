// com.eventmanagement.dto.EventDTO.java
package com.eventmanagement.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class EventDTO {
    private Long id;
    
    @NotBlank
    @Size(max = 100)
    private String name;
    
    @NotBlank
    @Size(max = 500)
    private String description;
    
    @NotNull
    @Future
    private LocalDateTime startDateTime;
    
    @NotNull
    @Future
    private LocalDateTime endDateTime;
    
    @NotBlank
    @Size(max = 200)
    private String location;
    
    @NotNull
    @Min(1)
    private Integer capacity;
    
    @NotNull
    @DecimalMin("0.0")
    private Double price;
}