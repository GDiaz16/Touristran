/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author gonza
 */
public class CityEntity {

    private String name;
    private int inhabitants;

    private String mostTouristicPlace;
    private String mostRelevantHotel;

    public CityEntity(String name, int inhabitants, String mostTouristicPlace, String mostRelevantHotel) {
        this.name = name;
        this.inhabitants = inhabitants;
        this.mostTouristicPlace = mostTouristicPlace;
        this.mostRelevantHotel = mostRelevantHotel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInhabitants() {
        return inhabitants;
    }

    public void setInhabitants(int inhabitants) {
        this.inhabitants = inhabitants;
    }

    public String getMostTouristicPlace() {
        return mostTouristicPlace;
    }

    public void setMostTouristicPlace(String mostTouristicPlace) {
        this.mostTouristicPlace = mostTouristicPlace;
    }

    public String getMostRelevantHotel() {
        return mostRelevantHotel;
    }

    public void setMostRelevantHotel(String mostRelevantHotel) {
        this.mostRelevantHotel = mostRelevantHotel;
    }
    
}
