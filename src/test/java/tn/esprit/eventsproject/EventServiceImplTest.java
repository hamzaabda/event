package tn.esprit.eventsproject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.eventsproject.entities.Event;
import tn.esprit.eventsproject.entities.Participant;
import tn.esprit.eventsproject.repositories.EventRepository;
import tn.esprit.eventsproject.repositories.LogisticsRepository;
import tn.esprit.eventsproject.repositories.ParticipantRepository;
import tn.esprit.eventsproject.services.EventServicesImpl;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;

class EventServicesImplTest {

    @Mock
    private EventRepository eventRepository;

    @Mock
    private ParticipantRepository participantRepository;

    @Mock
    private LogisticsRepository logisticsRepository;

    @InjectMocks
    private EventServicesImpl eventServices;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddParticipant() {
        // Create a participant and mock the repository behavior
        Participant participant = new Participant();
        when(participantRepository.save(participant)).thenReturn(participant);

        // Call the method under test
        Participant result = eventServices.addParticipant(participant);

        // Verify that the repository's save method was called with the correct participant
        verify(participantRepository, times(1)).save(participant);

        // Assert the result, if needed
        // assertEquals(participant, result);
    }

    // Similar tests can be written for other methods in EventServicesImpl

    // For example, testing addAffectEvenParticipant method
    @Test
    void testAddAffectEvenParticipant() {
        // Create an event and a participant, and mock the repository behavior
        Event event = new Event();
        Participant participant = new Participant();
        when(participantRepository.findById(anyInt())).thenReturn(java.util.Optional.of(participant));
        when(eventRepository.save(event)).thenReturn(event);

        // Call the method under test
        Event result = eventServices.addAffectEvenParticipant(event, 1);

        // Verify that the repository's save method was called with the correct event
        verify(eventRepository, times(1)).save(event);

        // Assert the result, if needed
        // assertEquals(event, result);
    }

    // Add more test methods for other functionalities in EventServicesImpl

}

