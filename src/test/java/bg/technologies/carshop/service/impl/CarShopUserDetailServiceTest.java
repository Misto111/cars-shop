package bg.technologies.carshop.service.impl;

import bg.technologies.carshop.model.entity.UserEntity;
import bg.technologies.carshop.model.entity.UserRoleEntity;
import bg.technologies.carshop.model.enums.UserRoleEnum;
import bg.technologies.carshop.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class CarShopUserDetailServiceTest {

    private CarShopUserDetailsService serviceToTest;

    @Mock
    private UserRepository mockUserRepository;

    @BeforeEach
    void setUp() {
        serviceToTest = new CarShopUserDetailsService(
                mockUserRepository);

    }

    @Test
    void testUserNotFound() {
        Assertions.assertThrows(
                UsernameNotFoundException.class,
                () -> serviceToTest.loadUserByUsername("hachi@abc.com")
        );

    }

    @Test
    void testUserFoundException() {

        UserEntity testUserEntity = createTestUser();

        when(mockUserRepository.findByEmail(testUserEntity.getEmail()))
                .thenReturn(Optional.of(testUserEntity));

        UserDetails userDetails =
                serviceToTest.loadUserByUsername(testUserEntity.getEmail());

        assertNotNull(userDetails);
        assertEquals(
                testUserEntity.getEmail(),
                userDetails.getUsername(),
                "Username not matched");

        assertTrue(
        containsAuthority(userDetails,"ROLE_" + UserRoleEnum.ADMIN),
                "The user is not admin");
        assertTrue(
                containsAuthority(userDetails, "ROLE_" + UserRoleEnum.USER),
                "The user is not user");

    }

    private boolean containsAuthority(UserDetails userDetails, String expectedAuthority) {
        return userDetails
                .getAuthorities()
                .stream()
                .anyMatch(a -> expectedAuthority.equals(a.getAuthority()));
    }

    private static UserEntity createTestUser() {

        return new UserEntity()
                .setFirstName("firstName")
                .setLastName("lastName")
                .setEmail("email")
                .setActive(false)
                .setPassword("password")
                .setRoles(List.of(
                        new UserRoleEntity().setRole(UserRoleEnum.ADMIN),
                        new UserRoleEntity().setRole(UserRoleEnum.USER)
                ));
    }

}


