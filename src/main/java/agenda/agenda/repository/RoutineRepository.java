package agenda.agenda.repository;

import agenda.agenda.model.RoutineModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoutineRepository extends JpaRepository<RoutineModel,Long> {
    List<RoutineModel> findByUsuarioId(Long usuarioId);
}
