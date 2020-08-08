package App.BusinessLayer.Controllers;

import App.BusinessLayer.Services.ToDoService;
import App.DataLayer.Models.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ToDo findById(@PathVariable int id){
        return toDoService.findById(id);
    }

    @PostMapping
    public ToDo create(@RequestBody ToDo toDo){
        return toDoService.save(toDo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDo> update(@RequestBody ToDo toDo){
        ToDo toDo1 = toDoService.findById(toDo.getId());
        if (toDo1 != null){
            return ResponseEntity.ok(toDoService.save(toDo));
        } else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        toDoService.deleteById(id);
    }
}
