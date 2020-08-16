package App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@SpringBootApplication
public class CitiesWebService {

    public static void main(String[] args) {
        // Creacion del servidor de Spring boot
        SpringApplication.run(CitiesWebService.class, args);
    }

}
