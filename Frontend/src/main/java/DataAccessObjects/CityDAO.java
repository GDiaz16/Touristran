/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObjects;

import Entities.CityEntity;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author gonza
 */
public class CityDAO {

    Client client = ClientBuilder.newClient();

    // Select
    public CityEntity getCity(int id) {
        return client
                .target("http://localhost:8080/api/todo/")
                .path(String.valueOf(id))
                .request(MediaType.APPLICATION_JSON)
                .get(CityEntity.class);
    }

    //Create
    public Response createCity(CityEntity cityEntity) {
        return client
                .target("http://localhost:8080/api/todo")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(cityEntity, MediaType.APPLICATION_JSON));
    }

    // Delete
    public CityEntity deletCity(int id) {
        return client
                .target("http://localhost:8080/api/todo/")
                .path(String.valueOf(id))
                .request(MediaType.APPLICATION_JSON)
                .delete(CityEntity.class);
    }

    // Update
    public Response updateCity(CityEntity cityEntity, int id) {
        return client
                .target("http://localhost:8080/api/todo")
                .path(String.valueOf(id))
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(cityEntity, MediaType.APPLICATION_JSON));
    }
}
