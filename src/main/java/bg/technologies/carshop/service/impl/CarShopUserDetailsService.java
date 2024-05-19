package bg.technologies.carshop.service.impl;

import bg.technologies.carshop.model.entity.UserEntity;
import bg.technologies.carshop.model.entity.UserRoleEntity;
import bg.technologies.carshop.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CarShopUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  public CarShopUserDetailsService(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return userRepository
        .findByEmail(email)
        .map(CarShopUserDetailsService::map)
        .orElseThrow(() -> new UsernameNotFoundException("User " + email + " not found!"));
  }

  private static UserDetails map(UserEntity userEntity) {
    return User
        .withUsername(userEntity.getEmail())
        .password(userEntity.getPassword())
        .authorities(userEntity.getRoles().stream().map(CarShopUserDetailsService::map).toList())
        .build();
  }

  private static GrantedAuthority map(UserRoleEntity userRoleEntity) {
    return new SimpleGrantedAuthority(
        "ROLE_" + userRoleEntity.getRole().name()
    );
  }
}
