package agenda.agenda.repository;

import agenda.agenda.model.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventModel,Long> {
    List<EventModel> findByUsuarioId(Long usuarioId);
}
