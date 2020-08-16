package App.BusinessLayer.Controllers;

import App.BusinessLayer.Services.TouristService;
import App.DataLayer.Models.TouristModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
// RequestMapping atiende las peticiones en la ruta dada por parametro
@RequestMapping("/api/tourists")
// CrossOrigin permite el acceso desde paginas web diferentes a localhost
// Por ser entorno de pruebas se le da acceso a cualquier pagina web externa
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class TouristController {

    // Autowired asigna un objeto a la instancia en el momento en el que
    // sea requerido
    @Autowired
    private TouristService touristService;

    // GetMapping obtiene valores en una sub ruta dada como parametro
    @GetMapping
    public List<TouristModel> findAll() {
        return touristService.findAll();
    }

    // GetMapping obtiene valores en una sub ruta dada como parametro
    @GetMapping("/{id}")
    public ResponseEntity<TouristModel> findById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(touristService.findById(id));
        } catch (JsonParseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        }

    }

    // PostMapping hace una peticion post a la ruta del controlador
    @PostMapping
    public ResponseEntity<TouristModel> create(@RequestBody TouristModel touristModel) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(touristService.save(touristModel));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // PutMapping hace una peticion put a la ruta del controlador
    @PutMapping("/{id}")
    public ResponseEntity<TouristModel> update(@RequestBody TouristModel touristModel) {
        try {
            TouristModel touristModel1
                    = touristService.findById(touristModel.getPkTourist());
            return ResponseEntity.status(HttpStatus.CREATED).body(touristService.save(touristModel));

        } catch (JsonParseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        }
    }

    // DeleteMapping hace una peticion delete a la ruta del controlador
    @DeleteMapping("/{id}")
    public ResponseEntity<TouristModel> deleteById(@PathVariable int id) {

        try {
            touristService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (JsonParseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }
}
