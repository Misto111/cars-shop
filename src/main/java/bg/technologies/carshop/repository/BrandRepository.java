package bg.technologies.carshop.repository;

import bg.technologies.carshop.model.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<BaseEntity, Long> {
}
