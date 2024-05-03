package bg.technologies.carshop.service.impl;

import bg.technologies.carshop.model.dto.CreateOfferDTO;
import bg.technologies.carshop.repository.OfferRepository;
import bg.technologies.carshop.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public UUID createOffer(CreateOfferDTO createOfferDTO) {

        throw new UnsupportedOperationException("Coming soon!");

    }
}
