package agenda.agenda.service;

import agenda.agenda.model.EventModel;
import agenda.agenda.model.RoutineModel;
import agenda.agenda.repository.RoutineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoutineService {
    @Autowired
    private RoutineRepository routineRepository;

    public List<RoutineModel> getAllRoutines() {
        return routineRepository.findAll();
    }

    public List<RoutineModel> getRoutineByUserId(Long usuarioId) {
        return routineRepository.findByUsuarioId(usuarioId);
    }

    public RoutineModel createRoutine(RoutineModel routine) {
        return routineRepository.save(routine);
    }

    public RoutineModel updateRoutine(Long id, RoutineModel routine) {
        if (routineRepository.existsById(id)) {
            routine.setId(id);
            return routineRepository.save(routine);
        }
        return null;
    }

    public boolean deleteRoutine(Long id) {
        if (routineRepository.existsById(id)) {
            routineRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
