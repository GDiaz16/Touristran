package App.BusinessLayer.Repositories;

import App.DataLayer.Models.ToDo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends CrudRepository<ToDo, Integer> {
}
