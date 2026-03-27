package daniel.Desafia.services.users;

import daniel.Desafia.dtos.users.request.LoginRequestUserDTO;
import daniel.Desafia.dtos.users.response.LoginResponseUserDTO;

public interface UserService {
    LoginResponseUserDTO login(LoginRequestUserDTO data);
}
