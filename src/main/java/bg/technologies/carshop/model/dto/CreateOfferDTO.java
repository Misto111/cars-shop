package bg.technologies.carshop.model.dto;

import bg.technologies.carshop.model.enums.EngineEnum;
import bg.technologies.carshop.model.enums.TransmissionEnum;

public record CreateOfferDTO(
        String description,
        Long modelId,
        EngineEnum engine,
        TransmissionEnum transmission,
        String imageUrl,
        Integer mileage,
        Integer price,
        Integer year
) {
}
