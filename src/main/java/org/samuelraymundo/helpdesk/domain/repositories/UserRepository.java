package org.samuelraymundo.helpdesk.domain.repositories;

import org.samuelraymundo.helpdesk.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
