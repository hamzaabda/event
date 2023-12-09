package tn.esprit.eventsproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.eventsproject.entities.Tache;

import java.io.Serializable;

// ParticipantDTO.java
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantDTO implements Serializable {
    String nom;
    String prenom;
    Tache tache;
    // Other fields if needed
}


