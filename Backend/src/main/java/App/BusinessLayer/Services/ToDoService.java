package App.BusinessLayer.Services;

import App.BusinessLayer.Repositories.ToDoRepository;
import App.DataLayer.Models.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public List<ToDo> findAll(){
        return (List<ToDo>) toDoRepository.findAll();
    }

    public ToDo findById(int id){
        return toDoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public ToDo save(ToDo toDo){
        return toDoRepository.save(toDo);
    }

    public void deleteById(int id){
        toDoRepository.deleteById(id);
    }
}
