package org.samuelraymundo.helpdesk.domain.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Client extends User{

    private List<Ticket> tickets = new ArrayList<>();

    public Client() {
        super();
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
