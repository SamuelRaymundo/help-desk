package org.samuelraymundo.helpdesk.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import org.samuelraymundo.helpdesk.domain.enums.Profile;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Client extends User implements Serializable {

    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "client")
    private List<Ticket> tickets = new ArrayList<>();

    public Client() {
        super();
        addProfiles(Profile.CLIENT);
    }

    public Client(Integer id, String name, String cpf, String email, String password, Set<Integer> profiles, LocalDate creationDate) {
        super(id, name, cpf, email, password, profiles, creationDate);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
