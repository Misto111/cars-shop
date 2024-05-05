package bg.technologies.carshop.service.impl;

import bg.technologies.carshop.model.dto.CreateOfferDTO;
import bg.technologies.carshop.model.entity.ModelEntity;
import bg.technologies.carshop.model.entity.OfferEntity;
import bg.technologies.carshop.repository.ModelRepository;
import bg.technologies.carshop.repository.OfferRepository;
import bg.technologies.carshop.service.OfferService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelRepository modelRepository;

    public OfferServiceImpl(OfferRepository offerRepository,
                            ModelRepository modelRepository) {
        this.offerRepository = offerRepository;
        this.modelRepository = modelRepository;
    }

    @Override
    public UUID createOffer(CreateOfferDTO createOfferDTO) {


        OfferEntity newOffer = map(createOfferDTO);

        ModelEntity modelEntity = modelRepository.
                findById(createOfferDTO.modelId())
                .orElseThrow(()-> new IllegalArgumentException("Model with id" + createOfferDTO.modelId() + " not found"));

        newOffer.setModel(modelEntity);

        newOffer = offerRepository.save(newOffer);

        return newOffer.getUuid();
    }

    private OfferEntity map(CreateOfferDTO createOfferDTO) {
        return new OfferEntity()
                .setUuid(UUID.randomUUID())
                .setDescription(createOfferDTO.description())
                .setEngine(createOfferDTO.engine())
                .setTransmission(createOfferDTO.transmission())
                .setImageUrl(createOfferDTO.imageUrl())
                .setMileage(createOfferDTO.mileage())
                .setPrice(BigDecimal.valueOf(createOfferDTO.price()))
                .setYear(createOfferDTO.year());
    }
}
