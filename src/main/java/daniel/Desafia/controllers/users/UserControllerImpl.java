package daniel.Desafia.controllers.users;

import daniel.Desafia.dtos.users.request.CreateRequestUserDTO;
import daniel.Desafia.dtos.users.request.LoginRequestUserDTO;
import daniel.Desafia.dtos.users.request.UpdateRequestUserDTO;
import daniel.Desafia.dtos.users.response.LoginResponseUserDTO;
import daniel.Desafia.services.users.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UserControllerImpl implements UserController {

    private final UserService service;

    public UserControllerImpl(UserService service)  {
        this.service = service;
    }

    @Override
    public ResponseEntity<LoginResponseUserDTO> login(LoginRequestUserDTO data) {
        return ResponseEntity.ok().body(service.login(data));
    }

    @Override
    public ResponseEntity<Void> register(CreateRequestUserDTO data) {
        return null;
    }

    @Override
    public ResponseEntity<Void> update(UpdateRequestUserDTO data) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(UUID id) {
        return null;
    }

}
