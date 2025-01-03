package org.samuelraymundo.helpdesk.domain.entities;

import org.samuelraymundo.helpdesk.domain.enums.Priority;
import org.samuelraymundo.helpdesk.domain.enums.Status;

import java.time.LocalDate;
import java.util.Objects;

public class Ticket {

    private Integer id;
    private LocalDate openingDate = LocalDate.now();
    private LocalDate closeDate;
    private Priority priority;
    private Status status;
    private String title;
    private String observations;

    private Technitian technitian;
    private Client client;

    public Ticket() {
    }

    public Ticket(Integer id,Priority priority, Status status, String title, String observations, Technitian technitian, Client client) {
        this.id = id;
        this.priority = priority;
        this.status = status;
        this.title = title;
        this.observations = observations;
        this.technitian = technitian;
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    public LocalDate getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(LocalDate closeDate) {
        this.closeDate = closeDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Technitian getTechnitian() {
        return technitian;
    }

    public void setTechnitian(Technitian technitian) {
        this.technitian = technitian;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
