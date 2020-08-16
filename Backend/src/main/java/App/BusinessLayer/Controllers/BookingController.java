package App.BusinessLayer.Controllers;

import App.BusinessLayer.Services.BookingService;
import App.DataLayer.Models.BookingModel;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;

@RestController
// RequestMapping atiende las peticiones en la ruta dada por parametro
@RequestMapping("/api/booking")
// CrossOrigin permite el acceso desde paginas web diferentes a localhost
// Por ser entorno de pruebas se le da acceso a cualquier pagina web externa
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class BookingController {

    // Autowired asigna un objeto a la instancia en el momento en el que
    // sea requerido
    @Autowired
    private BookingService bookingService;

    @GetMapping
    public List<BookingModel> findAll() {
        return bookingService.findAll();
    }

    // GetMapping obtiene valores en una sub ruta dada como parametro
    @GetMapping("/{id}")
    public ResponseEntity<BookingModel> findById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(bookingService.findById(id));
        } catch (JsonParseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // GetMapping obtiene valores en una sub ruta dada como parametro
    @GetMapping("/tourist/{id}")
    public List<BookingModel> findByfkTourist(@PathVariable int id) {
        return bookingService.findByfkTourist(id);
    }

    // GetMapping obtiene valores en una sub ruta dada como parametro
    @GetMapping("/city/{id}")
    public List<BookingModel> findByfkCity(@PathVariable int id) {
        return bookingService.findByfkCity(id);
    }

    // GetMapping obtiene valores en una sub ruta dada como parametro
    @GetMapping("/date")
    public List<BookingModel> findBydate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return bookingService.findBydate(date);
    }

    // PostMapping hace una peticion post a la ruta del controlador
    @PostMapping
    public ResponseEntity<BookingModel> create(@RequestBody BookingModel bookingModel) {

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.save(bookingModel));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // PutMapping hace una peticion put a la ruta del controlador
    @PutMapping("/{id}")
    public ResponseEntity<BookingModel> update(@RequestBody BookingModel bookingModel) {
        try {
            BookingModel bookingModel1
                    = bookingService.findById(bookingModel.getPkBooking());
            return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.save(bookingModel));

        } catch (JsonParseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        }
    }

    // DeleteMapping hace una peticion delete a la ruta del controlador
    @DeleteMapping("/{id}")
    public ResponseEntity<BookingModel> deleteById(@PathVariable int id) {

        try {
            bookingService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (JsonParseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }
}
