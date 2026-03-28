package daniel.Desafia.services.users;

import daniel.Desafia.dtos.users.request.CreateRequestUserDTO;
import daniel.Desafia.dtos.users.request.LoginRequestUserDTO;
import daniel.Desafia.dtos.users.response.LoginResponseUserDTO;

public interface UserService {
    LoginResponseUserDTO login(LoginRequestUserDTO data);
    void createUser(CreateRequestUserDTO data);
    void updateUser();

}
