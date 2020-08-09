package DataAccess;

import Entities.ToDoEntity;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Create {
    Client client = ClientBuilder.newClient();

    public Response createToDo(ToDoEntity toDoEntity){
        return client
                .target("http://localhost:8080/api/todo")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(toDoEntity, MediaType.APPLICATION_JSON));
    }
}
