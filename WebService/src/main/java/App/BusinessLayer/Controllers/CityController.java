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
@RequestMapping("/web-api/cities")
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

}
