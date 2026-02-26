package daniel.Desafia.controllers.users;

import daniel.Desafia.dtos.users.request.LoginRequestUserDTO;
import daniel.Desafia.dtos.users.response.LoginResponseUserDTO;
import daniel.Desafia.entities.UserEntity;
import org.springframework.http.ResponseEntity;

public class UserControllerImpl implements UserController {

    @Override
    public ResponseEntity<LoginResponseUserDTO> login(LoginRequestUserDTO data) {
        return null;
    }
}
