package daniel.Desafia.services.users;

import daniel.Desafia.dtos.users.request.CreateRequestUserDTO;
import daniel.Desafia.dtos.users.request.LoginRequestUserDTO;
import daniel.Desafia.dtos.users.response.LoginResponseUserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public LoginResponseUserDTO login(LoginRequestUserDTO data) {
        return null;
    }

    @Override
    public void createUser(CreateRequestUserDTO data) {
        
    }

    @Override
    public void updateUser() {

    }

    @Override
    public void deleteUser() {

    }
}
