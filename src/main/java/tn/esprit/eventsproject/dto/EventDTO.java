package tn.esprit.eventsproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
    ²

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class EventDTO implements Serializable {
    private int idEvent;
    private String description;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private float cout;
    private Set<ParticipantDTO> participants;
    private transient Set<LogisticsDTO> logistics;

    // Add any additional constructors or methods as needed
}
