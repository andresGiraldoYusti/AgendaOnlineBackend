package agenda.agenda.repository;

import agenda.agenda.model.UsuarioModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel,Long> {
    Optional<UsuarioModel> findByUsernameAndPassword(String username, String password);
}
