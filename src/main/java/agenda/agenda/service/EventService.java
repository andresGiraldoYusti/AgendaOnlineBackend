package agenda.agenda.service;

import agenda.agenda.model.EventModel;
import agenda.agenda.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<EventModel> getAllEvents() {
        return eventRepository.findAll();
    }

    public List<EventModel> getEventsByUserId(Long usuarioId) {
        return eventRepository.findByUsuarioId(usuarioId);
    }

    public EventModel createEvent(EventModel event) {
        return eventRepository.save(event);
    }

    public EventModel updateEvent(Long id, EventModel event) {
        if (eventRepository.existsById(id)) {
            event.setId(id);
            return eventRepository.save(event);
        }
        return null;
    }

    public boolean deleteEvent(Long id) {
        if (eventRepository.existsById(id)) {
            eventRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
