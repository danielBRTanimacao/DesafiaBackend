package daniel.Desafia.dtos.users.request;

public record UpdateRequestUserDTO(
        String username,
        String email,
        byte[] avatar
) {
}
