package org.samuelraymundo.helpdesk.domain.repositories;

import org.samuelraymundo.helpdesk.domain.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
