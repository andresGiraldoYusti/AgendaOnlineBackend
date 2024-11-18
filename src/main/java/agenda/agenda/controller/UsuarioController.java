package agenda.agenda.controller;

import agenda.agenda.model.UsuarioModel;
import agenda.agenda.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioService userService;

    @GetMapping
    public List<UsuarioModel> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> getUserById(@PathVariable Long id) {
        Optional<UsuarioModel> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UsuarioModel> createUser(@RequestBody UsuarioModel user) {
        UsuarioModel newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioModel> updateUser(@PathVariable Long id, @RequestBody UsuarioModel user) {
        UsuarioModel updatedUser = userService.updateUser(id, user);
        return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
