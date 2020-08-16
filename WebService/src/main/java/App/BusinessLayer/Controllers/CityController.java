package App.BusinessLayer.Controllers;

import App.BusinessLayer.Services.CityService;
import App.DataLayer.Models.CityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
// RequestMapping atiende las peticiones en la ruta dada por parametro
@RequestMapping("/web-api/cities")
// CrossOrigin permite el acceso desde paginas web diferentes a localhost
// Por ser entorno de pruebas se le da acceso a cualquier pagina web externa
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public class CityController {

    // Autowired asigna un objeto a la instancia en el momento en el que
    // sea requerido
    @Autowired
    private CityService cityService;

    // GetMapping obtiene valores en una sub ruta dada como parametro
    @GetMapping
    public List<CityModel> findAll() {
        return cityService.findAll();
    }

    // GetMapping obtiene valores en una sub ruta dada como parametro
    @GetMapping("/{id}")
    public ResponseEntity<CityModel> findById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(cityService.findById(id));
        } catch (JsonParseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        }

    }

}
