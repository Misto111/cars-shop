package bg.technologies.carshop.model.dto;

import java.util.List;

public record BrandDTO(String name,
                       List<ModelDTO> models
) {
}
