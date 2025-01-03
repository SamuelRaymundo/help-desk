package org.samuelraymundo.helpdesk.domain.repositories;

import org.samuelraymundo.helpdesk.domain.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
