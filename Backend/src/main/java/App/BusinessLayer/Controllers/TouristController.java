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
@RequestMapping("/api/tourists")
public class TouristController {
    @Autowired
    private TouristService touristService;

    @GetMapping
    public List<TouristModel> findAll(){
        return touristService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TouristModel> findById(@PathVariable int id){
        try {
            return ResponseEntity.ok(touristService.findById(id));
        }catch (  JsonParseException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        }

    }

    @PostMapping
    public ResponseEntity<TouristModel> create(@RequestBody TouristModel touristModel){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(touristService.save(touristModel));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }    }

    @PutMapping("/{id}")
    public ResponseEntity<TouristModel> update(@RequestBody TouristModel touristModel){
        try {
            TouristModel touristModel1 =
                    touristService.findById(touristModel.getPK_TOURIST());
            return ResponseEntity.status(HttpStatus.CREATED).body(touristService.save(touristModel));

        }catch (JsonParseException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TouristModel> deleteById(@PathVariable int id){

        try {
            touristService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }catch (EmptyResultDataAccessException e ){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }catch (JsonParseException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }
}
