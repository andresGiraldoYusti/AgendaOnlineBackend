package agenda.agenda.service;

import agenda.agenda.model.UsuarioModel;
import agenda.agenda.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public List<UsuarioModel> getAllUsers() {
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioModel> iniciarSesion(String username, String password) {
        return usuarioRepository.findByUsernameAndPassword(username, password);
    }

    public Optional<UsuarioModel> getUserById(long id){
        return usuarioRepository.findById(id);
    }

    public UsuarioModel createUser(UsuarioModel user) {
        return usuarioRepository.save(user);
    }

    public UsuarioModel updateUser(Long id, UsuarioModel user) {
        if (usuarioRepository.existsById(id)) {
            user.setId(id);
            return usuarioRepository.save(user);
        }
        return null;
    }

    public boolean deleteUser(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

}