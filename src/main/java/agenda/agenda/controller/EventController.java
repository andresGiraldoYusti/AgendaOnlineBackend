package agenda.agenda.controller;

import agenda.agenda.model.EventModel;
import agenda.agenda.repository.EventRepository;
import agenda.agenda.repository.UsuarioRepository;
import agenda.agenda.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {
    private EventService eventService;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<EventModel> getAllUsers() {
        return eventService.getAllEvents();
    }

    @GetMapping("/user/{id_usuario}")
    public List<EventModel> getEventsByUserId(@PathVariable("id_usuario") Long usuarioId) {
        return eventService.getEventsByUserId(usuarioId);
    }

    @PostMapping
    public ResponseEntity<EventModel> createEvent(@RequestBody EventModel event) {
        EventModel newEvent = eventService.createEvent(event);
        return new ResponseEntity<>(newEvent, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventModel> updateUser(@PathVariable Long id, @RequestBody EventModel user) {
        EventModel updatedEvent = eventService.updateEvent(id, user);
        return updatedEvent != null ? ResponseEntity.ok(updatedEvent) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        return eventService.deleteEvent(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}
