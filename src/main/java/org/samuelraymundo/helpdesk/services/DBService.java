package org.samuelraymundo.helpdesk.services;

import org.samuelraymundo.helpdesk.domain.entities.Client;
import org.samuelraymundo.helpdesk.domain.entities.Technitian;
import org.samuelraymundo.helpdesk.domain.entities.Ticket;
import org.samuelraymundo.helpdesk.domain.enums.Priority;
import org.samuelraymundo.helpdesk.domain.enums.Profile;
import org.samuelraymundo.helpdesk.domain.enums.Status;
import org.samuelraymundo.helpdesk.domain.repositories.ClientRepository;
import org.samuelraymundo.helpdesk.domain.repositories.TechnitianRepository;
import org.samuelraymundo.helpdesk.domain.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

@Service
public class DBService {


    @Autowired
    private TechnitianRepository technitianRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public void instantiateDb() {

        // Creating Technitian instances
        Technitian technitian1 = new Technitian(null,"Samuel","46677733300","samuel@mail.com","123", new HashSet<>(), LocalDate.now());
        technitian1.addProfiles(Profile.ADMIN);

        Technitian technitian2 = new Technitian(null, "Alice", "46677733301", "alice@mail.com", "456", new HashSet<>(), LocalDate.now());
        technitian2.addProfiles(Profile.TECHNICIAN);

        Technitian technitian3 = new Technitian(null, "John", "46677733302", "john@mail.com", "789", new HashSet<>(), LocalDate.now());
        technitian3.addProfiles(Profile.ADMIN);

        Technitian technitian4 = new Technitian(null, "Emma", "46677733303", "emma@mail.com", "101", new HashSet<>(), LocalDate.now());
        technitian4.addProfiles(Profile.TECHNICIAN);

        Technitian technitian5 = new Technitian(null, "Chris", "46677733304", "chris@mail.com", "202", new HashSet<>(), LocalDate.now());
        technitian5.addProfiles(Profile.ADMIN);

        Technitian technitian6 = new Technitian(null, "Sophia", "46677733305", "sophia@mail.com", "303", new HashSet<>(), LocalDate.now());
        technitian6.addProfiles(Profile.TECHNICIAN);

        // Creating Client instances
        Client client1 = new Client(null, "Susu", "4660973322300", "susu@mail.com", "321", new HashSet<>(), LocalDate.now());
        Client client2 = new Client(null, "Maggie", "4660973322310", "maggie@mail.com", "654", new HashSet<>(), LocalDate.now());
        Client client3 = new Client(null, "Jake", "4660973322320", "jake@mail.com", "987", new HashSet<>(), LocalDate.now());
        Client client4 = new Client(null, "Olivia", "4660973322330", "olivia@mail.com", "111", new HashSet<>(), LocalDate.now());
        Client client5 = new Client(null, "Liam", "4660973322340", "liam@mail.com", "222", new HashSet<>(), LocalDate.now());
        Client client6 = new Client(null, "Noah", "4660973322350", "noah@mail.com", "333", new HashSet<>(), LocalDate.now());

        // Creating Ticket instances
        Ticket ticket1 = new Ticket(null, Priority.MEDIUM, Status.IN_PROGRESS, "Chamado1","Primeiro chamado", technitian1, client1);
        Ticket ticket2 = new Ticket(null, Priority.HIGH, Status.OPEN, "Chamado2", "Segundo chamado", technitian2, client2);
        Ticket ticket3 = new Ticket(null, Priority.LOW, Status.CLOSED, "Chamado3", "Terceiro chamado", technitian3, client3);
        Ticket ticket4 = new Ticket(null, Priority.MEDIUM, Status.IN_PROGRESS, "Chamado4", "Quarto chamado", technitian4, client4);
        Ticket ticket5 = new Ticket(null, Priority.HIGH, Status.OPEN, "Chamado5", "Quinto chamado", technitian5, client5);
        Ticket ticket6 = new Ticket(null, Priority.LOW, Status.CLOSED, "Chamado6", "Sexto chamado", technitian6, client6);

        technitianRepository.saveAll(List.of(technitian1, technitian2, technitian3, technitian4, technitian5, technitian6));

        clientRepository.saveAll(List.of(client1, client2, client3, client4, client5, client6));

        ticketRepository.saveAll(List.of(ticket1, ticket2, ticket3, ticket4, ticket5, ticket6));

    }
}
