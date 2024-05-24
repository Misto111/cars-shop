package bg.technologies.carshop.testutils;

import bg.technologies.carshop.model.entity.*;
import bg.technologies.carshop.model.enums.EngineEnum;
import bg.technologies.carshop.model.enums.TransmissionEnum;
import bg.technologies.carshop.repository.BrandRepository;
import bg.technologies.carshop.repository.ExchangeRateRepository;
import bg.technologies.carshop.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Component
public class TestDataUtil {

  @Autowired
  private ExchangeRateRepository exchangeRateRepository;

  @Autowired
  private OfferRepository offerRepository;

  @Autowired
  private BrandRepository brandRepository;

  public void createExchangeRate(String currency, BigDecimal rate) {
    exchangeRateRepository.save(
        new ExchangeRateEntity().setCurrency(currency).setRate(rate)
    );
  }


  public OfferEntity createTestOffer(UserEntity owner) {

    // create test brand
    BrandEntity brandEntity = brandRepository.save(new BrandEntity()
        .setName("Test Brand")
        .setModels(List.of(
            new ModelEntity().setName("Test Model"),
            new ModelEntity().setName("Test Model1")
        )));

    // create test offer
    OfferEntity offer = new OfferEntity()
        .setModel(brandEntity.getModels().get(0))
        .setImageUrl("https://www.google.com")
        .setPrice(BigDecimal.valueOf(1000))
        .setYear(2020)
        .setUuid(UUID.randomUUID())
        .setDescription("Test Description")
        .setEngine(EngineEnum.PETROL)
        .setMileage(10000)
        .setTransmission(TransmissionEnum.MANUAL)
        .setSeller(owner);

    return offerRepository.save(offer);
  }
//
  public void cleanUp() {
    exchangeRateRepository.deleteAll();
    offerRepository.deleteAll();
    brandRepository.deleteAll();
  }
}
