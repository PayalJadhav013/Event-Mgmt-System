// com.eventmanagement.repository.AttendeeRepository.java
package com.eventmanagement.repository;

import com.eventmanagement.model.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee, Long> {
}