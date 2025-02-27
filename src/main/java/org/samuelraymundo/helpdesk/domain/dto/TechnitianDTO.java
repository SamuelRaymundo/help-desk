package org.samuelraymundo.helpdesk.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.samuelraymundo.helpdesk.domain.enums.Profile;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


public record TechnitianDTO(Integer id,
                            String name,
                            String cpf,
                            String email,
                            String password,
                            Set<Integer> profiles,
                            @JsonFormat(pattern = "dd/MM/yyyy") LocalDate creationDate ) {

    public TechnitianDTO {
        if (profiles == null) {
            profiles = new HashSet<>();
        }

        if (creationDate == null) {
        creationDate = LocalDate.now();
        }
    }

    public Set<Profile> getProfile() {
        return profiles.stream().map(x -> Profile.toEnum(x)).collect(Collectors.toSet());
    }

    public void addProfile(Profile profile) {
        this.profiles.add(profile.getCode());
    }

}
