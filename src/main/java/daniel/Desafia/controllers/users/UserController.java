package daniel.Desafia.controllers.users;

import daniel.Desafia.dtos.users.request.CreateRequestUserDTO;
import daniel.Desafia.dtos.users.request.LoginRequestUserDTO;
import daniel.Desafia.dtos.users.request.UpdateRequestUserDTO;
import daniel.Desafia.dtos.users.response.LoginResponseUserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/users")
public interface UserController {
    @PostMapping("/login")
    ResponseEntity<LoginResponseUserDTO> login(LoginRequestUserDTO data);

    @PostMapping
    ResponseEntity<Void> register(CreateRequestUserDTO data);

    @PutMapping
    ResponseEntity<Void> update(UpdateRequestUserDTO data);

    @DeleteMapping
    ResponseEntity<Void> delete();
}
