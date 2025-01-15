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

@Service
public class DBServices {


    @Autowired
    private TechnitianRepository technitianRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public void instantiateDb() {
        Technitian technitian1 = new Technitian(null,"Samuel","46677733300","samuel@mail.com","123", new HashSet<>(), LocalDate.now());
        technitian1.addProfiles(Profile.ADMIN);

        Client client1 = new Client(null, "Susu", "4660973322300", "susu@mail.com", "321", new HashSet<>(), LocalDate.now());


        Ticket ticket1 = new Ticket(null, Priority.MEDIUM, Status.IN_PROGRESS, "Chamado1","Primeiro chamado", technitian1, client1);

        technitianRepository.save(technitian1);
        clientRepository.save(client1);
        ticketRepository.save(ticket1);

    }
}
