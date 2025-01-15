package org.samuelraymundo.helpdesk.services.mapper;

import org.samuelraymundo.helpdesk.domain.dto.TechnitianDTO;
import org.samuelraymundo.helpdesk.domain.entities.Technitian;
import org.samuelraymundo.helpdesk.domain.enums.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class TechnitianMapper {

    public Technitian toEntity(TechnitianDTO dto) {
        return new Technitian(
                dto.id(),
                dto.name(),
                dto.cpf(),
                dto.email(),
                dto.password(),
                dto.profiles(),
                dto.creationDate()
        );
    }

    public TechnitianDTO toDTO(Technitian technitian) {
        return new TechnitianDTO(
                technitian.getId(),
                technitian.getName(),
                technitian.getCpf(),
                technitian.getEmail(),
                technitian.getPassword(),
                technitian.getProfiles().stream().map(Profile::getCode).collect(Collectors.toSet()),
                technitian.getCreationDate()
        );
    }
}
