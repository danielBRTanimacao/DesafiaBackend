package daniel.Desafia.dtos.users.request;

import jakarta.validation.constraints.NotBlank;

public record CreateRequestUserDTO(
        @NotBlank
        String username,
        @NotBlank
        String email,
        @NotBlank
        String password
) {
}
