package bg.technologies.carshop.repository;

import bg.technologies.carshop.model.entity.ExchangeRateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRateEntity, String> {
}
