/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObjects;

import Entities.TouristEntity;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author gonza
 */
public class TouristDAO {

    Client client = ClientBuilder.newClient();

    // Select
    public TouristEntity getTourist(int id) {
        return client
                .target("http://localhost:8080/api/tourists/2")
                //.path(String.valueOf(id))
                .request(MediaType.APPLICATION_JSON)
                .get(TouristEntity.class);
    }

    // Select all
    public List<TouristEntity> getAllTourist() {
        
        return client
                .target("http://localhost:8080/api/tourists")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<TouristEntity>>() {});
    }

    //Create
    public Response createTourist(TouristEntity touristEntity) {
        return client
                .target("http://localhost:8080/api/todo")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(touristEntity, MediaType.APPLICATION_JSON));
    }

    // Delete
    public TouristEntity deletTourist(int id) {
        return client
                .target("http://localhost:8080/api/todo/")
                .path(String.valueOf(id))
                .request(MediaType.APPLICATION_JSON)
                .delete(TouristEntity.class);
    }

    // Update
    public Response updateTourist(TouristEntity touristEntity, int id) {
        return client
                .target("http://localhost:8080/api/todo")
                .path(String.valueOf(id))
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(touristEntity, MediaType.APPLICATION_JSON));
    }
}
