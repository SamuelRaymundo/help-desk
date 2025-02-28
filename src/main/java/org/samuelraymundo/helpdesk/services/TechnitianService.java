package org.samuelraymundo.helpdesk.services;

import org.samuelraymundo.helpdesk.domain.dto.TechnitianDTO;
import org.samuelraymundo.helpdesk.domain.entities.Technitian;
import org.samuelraymundo.helpdesk.domain.entities.User;
import org.samuelraymundo.helpdesk.domain.repositories.TechnitianRepository;
import org.samuelraymundo.helpdesk.domain.repositories.UserRepository;
import org.samuelraymundo.helpdesk.services.exceptions.DataIntegrityViolationException;
import org.samuelraymundo.helpdesk.services.exceptions.ObjectNotFoundException;
import org.samuelraymundo.helpdesk.services.mapper.TechnitianMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class TechnitianService {

    @Autowired
    private TechnitianRepository technitianRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TechnitianMapper technitianMapper;


    public Technitian findById(Integer id) {
        Optional<Technitian> obj = technitianRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID:" + id));
    }

    public List<Technitian> findAll() {
        return technitianRepository.findAll();
    }
    public TechnitianDTO create(TechnitianDTO technitianDTO) {
        cpfValidationAndEmail(technitianDTO);
        var entity = technitianMapper.toEntity(technitianDTO);
        var savedEntity = technitianRepository.save(entity);
        return technitianMapper.toDTO(savedEntity);
    }

    private void cpfValidationAndEmail(TechnitianDTO technitianDTO) {
        Optional<User> obj = userRepository.findByCpf(technitianDTO.cpf());
        if (obj.isPresent() && !obj.get().getId().equals(technitianDTO.id())) {
            throw new DataIntegrityViolationException("CPF já cadastrado");
        }

        obj = userRepository.findByEmail(technitianDTO.email());

        if (obj.isPresent() && !obj.get().getId().equals(technitianDTO.id())) {
            throw new DataIntegrityViolationException("E-mail já cadastrado");
        }
    }


    public Technitian update(Integer id, TechnitianDTO dto) {
        Technitian obj = technitianRepository.findById(id).get();

        obj.setName(dto.name());
        obj.setCpf(dto.cpf());
        obj.setEmail(dto.email());
        obj.setPassword(dto.password());

        return technitianRepository.save(obj);
    }

}
