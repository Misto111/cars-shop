package bg.technologies.carshop.repository;

import bg.technologies.carshop.model.entity.BaseEntity;
import bg.technologies.carshop.model.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<BaseEntity, Long> {


    @Query("SELECT b FROM BrandEntity b")
    List<BrandEntity> getAllBrands();
}
