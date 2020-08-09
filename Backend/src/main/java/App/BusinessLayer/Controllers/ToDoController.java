package App.BusinessLayer.Controllers;

import App.BusinessLayer.Services.ToDoService;
import App.DataLayer.Models.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @GetMapping
    public List<ToDo> findAll(){
        return toDoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDo> findById(@PathVariable int id){
        try {
            return ResponseEntity.ok(toDoService.findById(id));
        }catch (  JsonParseException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        }

    }

    @PostMapping
    public ResponseEntity<ToDo> create(@RequestBody ToDo toDo){
        return ResponseEntity.status(HttpStatus.CREATED).body(toDoService.save(toDo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDo> update(@RequestBody ToDo toDo){
        try {
            ToDo toDo1 = toDoService.findById(toDo.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(toDoService.save(toDo));

        }catch (JsonParseException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ToDo> deleteById(@PathVariable int id){

        try {
            toDoService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }catch (EmptyResultDataAccessException e ){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }catch (JsonParseException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }
}
