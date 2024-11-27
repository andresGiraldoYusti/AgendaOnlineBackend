package agenda.agenda.controller;

import agenda.agenda.model.EventModel;
import agenda.agenda.model.RoutineModel;
import agenda.agenda.repository.RoutineRepository;
import agenda.agenda.repository.UsuarioRepository;
import agenda.agenda.service.RoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routine")
public class RoutineController {
    private RoutineService routineService;

    @Autowired
    private RoutineRepository routineRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public RoutineController(RoutineService routineService) {
        this.routineService = routineService;
    }

    @GetMapping
    public List<RoutineModel> getAllRoutine() {
        return routineService.getAllRoutines();
    }

    @GetMapping("/user/{id_usuario}")
    public List<RoutineModel> getRoutineByUserId(@PathVariable("id_usuario") Long usuarioId) {
        return routineService.getRoutineByUserId(usuarioId);
    }

    @PostMapping
    public ResponseEntity<RoutineModel> createRoutine(@RequestBody RoutineModel routine) {
        RoutineModel newRoutine = routineService.createRoutine(routine);
        return new ResponseEntity<>(newRoutine, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoutineModel> updateRoutine(@PathVariable Long id, @RequestBody RoutineModel routine) {
        RoutineModel updatedRoutine = routineService.updateRoutine(id, routine);
        return updatedRoutine != null ? ResponseEntity.ok(updatedRoutine) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoutine(@PathVariable Long id) {
        return routineService.deleteRoutine(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
