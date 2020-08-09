package DataAccess;

import Entities.ToDoEntity;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class Delete {
    Client client = ClientBuilder.newClient();

    public ToDoEntity deleteToDo(int id){
        return client
                .target("http://localhost:8080/api/todo/")
                .path(String.valueOf(id))
                .request(MediaType.APPLICATION_JSON)
                .delete(ToDoEntity.class);
    }
}
