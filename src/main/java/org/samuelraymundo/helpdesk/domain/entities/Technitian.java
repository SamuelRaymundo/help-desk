package org.samuelraymundo.helpdesk.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import org.samuelraymundo.helpdesk.domain.enums.Profile;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Technitian extends User implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @OneToMany(mappedBy = "technitian")
    private List<Ticket> tickets = new ArrayList<>();

    public Technitian() {
        super();
        addProfiles(Profile.CLIENT);
    }

    public Technitian(Integer id, String name, String cpf, String email, String password, Set<Integer> profiles, LocalDate creationDate) {
        super(id, name, cpf, email, password, profiles, creationDate);
        addProfiles(Profile.CLIENT);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
