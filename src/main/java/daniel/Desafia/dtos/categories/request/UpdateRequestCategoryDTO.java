package daniel.Desafia.dtos.categories.request;

import jakarta.validation.constraints.NotBlank;

public record UpdateRequestCategoryDTO(
        @NotBlank
        Long id,
        String name,
        byte[] icon
) {
}
