package DataAccess;

import Entities.ToDoEntity;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Update {
    Client client = ClientBuilder.newClient();

    public Response updateToDo(ToDoEntity toDoEntity, int id){
        return client
                .target("http://localhost:8080/api/todo")
                .path(String.valueOf(id))
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(toDoEntity, MediaType.APPLICATION_JSON));
    }
}
