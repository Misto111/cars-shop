package bg.technologies.carshop.repository;

import bg.technologies.carshop.model.entity.BaseEntity;
import bg.technologies.carshop.model.entity.BrandEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<BaseEntity, Long> {

    @EntityGraph( //По този начин ще дръпнем всичките наща на веднъж и избягваме n+1 problem
            value = "brandWithModels", //даваме името като в BrandEntity, което сме дали
            attributePaths = "models" //изброяваме тези, от които се интересуваме
    )
    @Query("SELECT b FROM BrandEntity b")
    List<BrandEntity> getAllBrands();
}
