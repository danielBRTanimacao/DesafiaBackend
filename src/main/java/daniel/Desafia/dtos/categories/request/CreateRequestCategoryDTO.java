package daniel.Desafia.dtos.categories.request;

import jakarta.validation.constraints.NotBlank;

public record CreateRequestCategoryDTO(
        @NotBlank
        String name,
        byte[] icon
) {
}
