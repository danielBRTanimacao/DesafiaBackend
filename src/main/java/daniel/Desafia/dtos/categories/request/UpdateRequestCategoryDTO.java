package daniel.Desafia.dtos.categories.request;

public record UpdateRequestCategoryDTO(
        Long id,
        String title,
        byte[] icon
) {
}
