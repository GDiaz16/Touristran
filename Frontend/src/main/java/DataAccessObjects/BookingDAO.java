/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObjects;

import Entities.BookingEntity;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author gonza
 */
public class BookingDAO {
    Client client = ClientBuilder.newClient();

    // Select
    public BookingEntity getBooking(int id) {
        return client
                .target("http://localhost:8080/api/todo/")
                .path(String.valueOf(id))
                .request(MediaType.APPLICATION_JSON)
                .get(BookingEntity.class);
    }

    //Create
    public Response createBooking(BookingEntity bookingEntity) {
        return client
                .target("http://localhost:8080/api/todo")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(bookingEntity, MediaType.APPLICATION_JSON));
    }

    // Delete
    public BookingEntity deletBooking(int id) {
        return client
                .target("http://localhost:8080/api/todo/")
                .path(String.valueOf(id))
                .request(MediaType.APPLICATION_JSON)
                .delete(BookingEntity.class);
    }

    // Update
    public Response updateBooking(BookingEntity bookingEntity, int id) {
        return client
                .target("http://localhost:8080/api/todo")
                .path(String.valueOf(id))
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(bookingEntity, MediaType.APPLICATION_JSON));
    }
}
