package App.BusinessLayer.Controllers;

import App.BusinessLayer.Services.BookingService;
import App.DataLayer.Models.BookingModel;
import App.DataLayer.Models.CityModel;
import App.DataLayer.Models.TouristModel;
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
@RequestMapping("/api/booking")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public List<BookingModel> findAll() {
        return bookingService.findAll();
    }

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

    @GetMapping("/tourist/{id}")
    public List<BookingModel> findByfkTourist(@PathVariable int id) {
        return bookingService.findByfkTourist(id);
    }

    @GetMapping("/city/{id}")
    public List<BookingModel> findByfkCity(@PathVariable int id) {
        return bookingService.findByfkCity(id);
    }

    @GetMapping("/date")
    public List<BookingModel> findBydate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return bookingService.findBydate(date);
    }

    @PostMapping
    public ResponseEntity<BookingModel> create(@RequestBody BookingModel bookingModel) {

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.save(bookingModel));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

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
