package bg.technologies.carshop.service;

import bg.technologies.carshop.model.dto.CreateOfferDTO;
import bg.technologies.carshop.model.dto.OfferDetailDTO;
import bg.technologies.carshop.model.dto.OfferSummaryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;
import java.util.UUID;

public interface OfferService {

    UUID createOffer(CreateOfferDTO createOfferDTO, UserDetails seller);

    Page<OfferSummaryDTO> getAllOffers(Pageable pageable);

    Optional<OfferDetailDTO> getOfferDetail(UUID offerUUID, UserDetails viewer);

    void deleteOffer(UUID offerUuid);

    boolean isOwner(UUID uuid, String userName);
}
