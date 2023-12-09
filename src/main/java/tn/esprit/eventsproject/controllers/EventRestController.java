package tn.esprit.eventsproject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.eventsproject.dto.EventDTO;
import tn.esprit.eventsproject.dto.LogisticsDTO;
import tn.esprit.eventsproject.dto.ParticipantDTO;
import tn.esprit.eventsproject.entities.Event;
import tn.esprit.eventsproject.entities.Logistics;
import tn.esprit.eventsproject.entities.Participant;
import tn.esprit.eventsproject.services.IEventServices;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RequestMapping("event")
@RestController
public class EventRestController {
    private final IEventServices eventServices;

    @PostMapping("/addPart")
    public ParticipantDTO addParticipant(@RequestBody ParticipantDTO participantDTO) {
        // Convert DTO to entity
        Participant participant = convertDtoToEntity(participantDTO);

        // Call the service method with the entity
        Participant savedParticipant = eventServices.addParticipant(participant);

        // Convert the saved entity back to DTO
        return convertEntityToDto(savedParticipant);
    }

    private Participant convertDtoToEntity(ParticipantDTO participantDTO) {
        Participant participant = new Participant();
        participant.setNom(participantDTO.getNom());
        participant.setPrenom(participantDTO.getPrenom());
        participant.setTache(participantDTO.getTache());
        // Set other fields if needed

        return participant;
    }

    private ParticipantDTO convertEntityToDto(Participant participant) {
        ParticipantDTO participantDTO = new ParticipantDTO();
        participantDTO.setNom(participant.getNom());
        participantDTO.setPrenom(participant.getPrenom());
        participantDTO.setTache(participant.getTache());
        // Set other fields if needed

        return participantDTO;
    }

    @PostMapping("/addEvent/{id}")
    public EventDTO addEventPart(@RequestBody EventDTO eventDTO, @PathVariable("id") int idPart) {
        // Convert EventDTO to Event entity if needed
        Event event = convertToEntity(eventDTO);

        // Call the service method with the entity
        Event resultEvent = eventServices.addAffectEvenParticipant(event, idPart);

        // Convert the result back to DTO before returning
        return convertToDTO(resultEvent);
    }

    // Utility method to convert Event to EventDTO
    private EventDTO convertToDTO(Event event) {
        // Implement the conversion logic here
        // Map fields from the Event entity to the EventDTO

        EventDTO eventDTO = new EventDTO();
        eventDTO.setIdEvent(event.getIdEvent());
        // Map other fields...

        return eventDTO;
    }

    // Utility method to convert EventDTO to Event
    private Event convertToEntity(EventDTO eventDTO) {
        // Implement the conversion logic here
        // Map fields from the EventDTO to the Event entity

        Event event = new Event();
        event.setIdEvent(eventDTO.getIdEvent());
        // Map other fields...

        return event;
    }

    @PutMapping("/addAffectLog/{description}")
    public LogisticsDTO addAffectLog(@RequestBody LogisticsDTO logisticsDTO, @PathVariable("description") String descriptionEvent) {
        // Convert LogisticsDTO to Logistics entity if needed
        Logistics logistics = convertToEntity(logisticsDTO);

        // Call the service method with the entity
        Logistics resultLogistics = eventServices.addAffectLog(logistics, descriptionEvent);

        // Convert the result back to DTO before returning
        return convertToDTO(resultLogistics);
    }

    @GetMapping("/getLogs/{d1}/{d2}")
    public List<LogisticsDTO> getLogistiquesDates(@PathVariable("d1") LocalDate dateDebut, @PathVariable("d2") LocalDate dateFin) {
        // Call the service method to get Logistics entities
        List<Logistics> logisticsList = eventServices.getLogisticsDates(dateDebut, dateFin);

        // Convert the list of Logistics entities to a list of LogisticsDTOs before returning
        return logisticsList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    // Utility method to convert Logistics to LogisticsDTO
    private LogisticsDTO convertToDTO(Logistics logistics) {
        // Implement the conversion logic here
        // Map fields from the Logistics entity to the LogisticsDTO

        LogisticsDTO logisticsDTO = new LogisticsDTO();
        logisticsDTO.setIdLog(logistics.getIdLog());
        logisticsDTO.setDescription(logistics.getDescription());
        logisticsDTO.setReserve(logistics.isReserve());
        logisticsDTO.setPrixUnit(logistics.getPrixUnit());
        logisticsDTO.setQuantite(logistics.getQuantite());

        return logisticsDTO;
    }

    // Utility method to convert LogisticsDTO to Logistics
    private Logistics convertToEntity(LogisticsDTO logisticsDTO) {
        // Implement the conversion logic here
        // Map fields from the LogisticsDTO to the Logistics entity

        Logistics logistics = new Logistics();
        logistics.setIdLog(logisticsDTO.getIdLog());
        logistics.setDescription(logisticsDTO.getDescription());
        logistics.setReserve(logisticsDTO.isReserve());
        logistics.setPrixUnit(logisticsDTO.getPrixUnit());
        logistics.setQuantite(logisticsDTO.getQuantite());

        return logistics;
    }

}
