package daniel.Desafia.dtos.users.request;

import jakarta.validation.constraints.NotBlank;

public record LoginRequestUserDTO(
        @NotBlank
        String username,
        @NotBlank
        String password
){}
