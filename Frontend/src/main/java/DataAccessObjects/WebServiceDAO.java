/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObjects;

import Entities.CityEntity;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author gonza
 */
public class WebServiceDAO {

    Client client = ClientBuilder.newClient();

    // Select
    public CityEntity getBooking(int id) {
        return client
                .target("http://localhost:8080/api/todo/")
                .path(String.valueOf(id))
                .request(MediaType.APPLICATION_JSON)
                .get(CityEntity.class);
    }
}
