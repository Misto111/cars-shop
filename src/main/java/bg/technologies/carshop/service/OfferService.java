package bg.technologies.carshop.service;

import bg.technologies.carshop.model.dto.CreateOfferDTO;
import bg.technologies.carshop.model.dto.OfferDetailDTO;
import bg.technologies.carshop.model.dto.OfferSummaryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface OfferService {

    UUID createOffer(CreateOfferDTO createOfferDTO);

    Page<OfferSummaryDTO> getAllOffers(Pageable pageable);

    Optional<OfferDetailDTO> getOfferDetail(UUID offerUUID);

    void deleteOffer(UUID offerUuid);
}
