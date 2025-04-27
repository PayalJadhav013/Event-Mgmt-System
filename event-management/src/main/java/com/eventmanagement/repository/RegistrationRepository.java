// com.eventmanagement.repository.RegistrationRepository.java
package com.eventmanagement.repository;

import com.eventmanagement.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
}