package org.samuelraymundo.helpdesk.services;

import org.samuelraymundo.helpdesk.domain.entities.Technitian;
import org.samuelraymundo.helpdesk.domain.repositories.TechnitianRepository;
import org.samuelraymundo.helpdesk.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechnitianService {

    @Autowired
    private TechnitianRepository technitianRepository;

    public Technitian findById(Integer id) {
        Optional<Technitian> obj = technitianRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID:" + id));
    }

    public List<Technitian> findAll() {
        return technitianRepository.findAll();
    }
}
