package org.samuelraymundo.helpdesk.domain.repositories;

import org.samuelraymundo.helpdesk.domain.entities.Technitian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnitianRepository extends JpaRepository<Technitian, Integer> {
}
