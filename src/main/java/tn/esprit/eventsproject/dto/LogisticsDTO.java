package tn.esprit.eventsproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LogisticsDTO implements Serializable {
    private int idLog;
    private String description;
    private boolean reserve;
    private float prixUnit;
    private int quantite;
}

