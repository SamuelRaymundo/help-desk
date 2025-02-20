package org.samuelraymundo.helpdesk.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.samuelraymundo.helpdesk.domain.enums.Priority;
import org.samuelraymundo.helpdesk.domain.enums.Status;

import java.time.LocalDate;

public record TicketDTO(Integer id,
                        @JsonFormat(pattern = "dd/MM/yyyy") LocalDate openingDate,
                        @JsonFormat(pattern = "dd/MM/yyyy") LocalDate closeDate,
                        Priority priority,
                        Status status,
                        String title,
                        String observations) {
}
