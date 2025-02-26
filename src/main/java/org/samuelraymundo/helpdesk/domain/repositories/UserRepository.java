package org.samuelraymundo.helpdesk.domain.repositories;

import org.samuelraymundo.helpdesk.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByCpf(String cpf);
    Optional<User> findByEmail(String email);
}
