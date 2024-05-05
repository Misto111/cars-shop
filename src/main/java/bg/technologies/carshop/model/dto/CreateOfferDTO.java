package bg.technologies.carshop.model.dto;

import bg.technologies.carshop.model.enums.EngineEnum;
import bg.technologies.carshop.model.enums.TransmissionEnum;
import jakarta.validation.constraints.*;

public record CreateOfferDTO(

        @NotEmpty
        @Size(min = 5, max = 512)
        String description,

        @Positive
        @NotNull
        Long modelId,


        @NotNull
        EngineEnum engine,

        @NotNull
        TransmissionEnum transmission,

        @NotEmpty
        String imageUrl,

        @Positive
        @NotNull
        Integer mileage,

        @Positive
        @NotNull
        Integer price,

        @NotNull(message = "Year must be provided")
        @Min(1930)
        Integer year
) {

        public static CreateOfferDTO empty() {

                return new CreateOfferDTO(null, null, null, null, null, null, null, null);
        }
}
