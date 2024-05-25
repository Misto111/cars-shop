package bg.technologies.carshop;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;


@OpenAPIDefinition(
        info = @Info(
                title = "Carshop",
                version = "0.0.1",
                description = "The REST API of carshop"
        ),
        servers = {
                @Server(
                        url = "http://localhost:8080",
                        description = "Local server"
                )
        }
)
@EnableScheduling
@EnableCaching
@SpringBootApplication
public class CarsShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarsShopApplication.class, args);
    }

}
