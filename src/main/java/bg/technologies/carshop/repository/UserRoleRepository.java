package bg.technologies.carshop.repository;



import bg.technologies.carshop.model.entity.UserRoleEntity;
import bg.technologies.carshop.model.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

  List<UserRoleEntity> findAllByRoleIn(List<UserRoleEnum> roles);

}
