package org.samuelraymundo.helpdesk.services.mapper;

import org.samuelraymundo.helpdesk.domain.dto.TechnitianDTO;
import org.samuelraymundo.helpdesk.domain.entities.Technitian;
import org.samuelraymundo.helpdesk.domain.enums.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TechnitianMapper {

    public Technitian toEntity(TechnitianDTO dto) {
        if (dto == null) return null;

        Set<Integer> profileCodes = dto.profiles() != null ? dto.profiles() : new HashSet<>();

        return new Technitian(
                dto.id(),
                dto.name(),
                dto.cpf(),
                dto.email(),
                dto.password(),
                profileCodes,
                dto.creationDate()
        );
    }

    public TechnitianDTO toDTO(Technitian technitian) {
        if (technitian == null) return null;

        Set<Integer> profileCodes = technitian.getProfiles() != null
                ? technitian.getProfiles().stream().map(Profile::getCode).collect(Collectors.toSet())
                : new HashSet<>();

        return new TechnitianDTO(
                technitian.getId(),
                technitian.getName(),
                technitian.getCpf(),
                technitian.getEmail(),
                null,
                profileCodes,
                technitian.getCreationDate()
        );
    }
}
