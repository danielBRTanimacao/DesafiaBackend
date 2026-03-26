package daniel.Desafia.controllers.users;

import daniel.Desafia.dtos.users.request.CreateRequestUserDTO;
import daniel.Desafia.dtos.users.request.LoginRequestUserDTO;
import daniel.Desafia.dtos.users.request.UpdateRequestUserDTO;
import daniel.Desafia.dtos.users.response.LoginResponseUserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("api/users")
public interface UserController {
    @PostMapping("/login")
    ResponseEntity<LoginResponseUserDTO> login(LoginRequestUserDTO data);

    @PostMapping
    ResponseEntity<Void> register(CreateRequestUserDTO data);

    @PutMapping
    ResponseEntity<Void> update(UpdateRequestUserDTO data);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable UUID id);
}
