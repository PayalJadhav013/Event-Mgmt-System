// com.eventmanagement.dto.RegistrationDTO.java
package com.eventmanagement.dto;

import lombok.Data;

@Data
public class RegistrationDTO {
    private Long id;
    private Long eventId;
    private Long attendeeId;
    private String eventName;
    private String attendeeName;
    private String registrationDate;
	private Long id2;
	private String name;
	private String string;

    // Add getters and setters if not using @Data
    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getAttendeeId() {
        return attendeeId;
    }

    public void setAttendeeId(Long attendeeId) {
        this.attendeeId = attendeeId;
    }

	public void setId(Long id2) {
		this.id2 = id2;
		
	}

	public void setEventName(String name) {
		this.name = name;
		
	}

	public void setAttendeeName(String name) {
		this.name = name;
		
	}

	public void setRegistrationDate(String string) {
		 this.string = string;
		
	}
}