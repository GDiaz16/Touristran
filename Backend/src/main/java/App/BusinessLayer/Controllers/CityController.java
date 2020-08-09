package App.BusinessLayer.Controllers;

import App.BusinessLayer.Services.CityService;
import App.DataLayer.Models.CityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping
    public List<CityModel> findAll(){
        return cityService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityModel> findById(@PathVariable int id){
        try {
            return ResponseEntity.ok(cityService.findById(id));
        }catch (  JsonParseException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        }

    }

    @PostMapping
    public ResponseEntity<CityModel> create(@RequestBody CityModel cityModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(cityService.save(cityModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CityModel> update(@RequestBody CityModel cityModel){
        try {
            CityModel cityModel1 = cityService.findById(cityModel.getPK_CITY());
            return ResponseEntity.status(HttpStatus.CREATED).body(cityService.save(cityModel));

        }catch (JsonParseException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CityModel> deleteById(@PathVariable int id){

        try {
            cityService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }catch (EmptyResultDataAccessException e ){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }catch (JsonParseException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }
}
