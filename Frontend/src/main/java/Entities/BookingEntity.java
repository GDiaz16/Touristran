/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author gonza
 */
public class BookingEntity {

    private int fkTourist;
    private int fkCity;
    private Date date;

    public BookingEntity(int fkTourist, int fkCity, Date date) {
        this.fkTourist = fkTourist;
        this.fkCity = fkCity;
        this.date = date;
    }

    public int getFkTourist() {
        return fkTourist;
    }

    public void setFkTourist(int fkTourist) {
        this.fkTourist = fkTourist;
    }

    public int getFkCity() {
        return fkCity;
    }

    public void setFkCity(int fkCity) {
        this.fkCity = fkCity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
