package bg.technologies.carshop.service;

import bg.technologies.carshop.model.dto.CreateOfferDTO;

import java.util.UUID;

public interface OfferService {

    UUID createOffer(CreateOfferDTO createOfferDTO);
}
