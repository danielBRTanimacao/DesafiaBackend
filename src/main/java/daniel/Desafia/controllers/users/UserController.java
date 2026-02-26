package daniel.Desafia.controllers.users;

import daniel.Desafia.dtos.users.request.LoginRequestUserDTO;
import daniel.Desafia.dtos.users.response.LoginResponseUserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/users")
public interface UserController {
    ResponseEntity<LoginResponseUserDTO> login(LoginRequestUserDTO data);
}
