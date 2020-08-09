package App;

import App.BusinessLayer.Controllers.CityController;
import App.BusinessLayer.Services.CityService;
import App.DataLayer.Models.CityModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@SpringBootApplication
public class CitiesWebService {

	public static void main(String[] args) {
		SpringApplication.run(CitiesWebService.class, args);
		CityService cityService = new CityService();
//		cityService.save(new CityModel("Bogotá", 7000000, "Plaza de " +
//				"Bolivar", "Tequendama"));
	}

}
