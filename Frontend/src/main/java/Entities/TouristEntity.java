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
public class TouristEntity {

    private int pkTourist;
    private int fkCity;
    private String name;
    private Date birthday;
    private String idOfTourist;
    private String idType;
    private int travelFrequencyInMonths;
    private double budget;
    private boolean hasCreditCard;

    public TouristEntity() {

    }

    public TouristEntity(int pkTourist, int fkCity, String name, Date birthday, String idOfTourist, String idType, int travelFrequencyInMonths, double budget, boolean hasCreditCard) {
        this.pkTourist = pkTourist;
        this.fkCity = fkCity;
        this.name = name;
        this.birthday = birthday;
        this.idOfTourist = idOfTourist;
        this.idType = idType;
        this.travelFrequencyInMonths = travelFrequencyInMonths;
        this.budget = budget;
        this.hasCreditCard = hasCreditCard;
    }

    public TouristEntity( int fkCity, String name, Date birthday, String idOfTourist, String idType, int travelFrequencyInMonths, double budget, boolean hasCreditCard) {
        this.fkCity = fkCity;
        this.name = name;
        this.birthday = birthday;
        this.idOfTourist = idOfTourist;
        this.idType = idType;
        this.travelFrequencyInMonths = travelFrequencyInMonths;
        this.budget = budget;
        this.hasCreditCard = hasCreditCard;
    }
    
    public int getPkTourist() {
        return pkTourist;
    }

    public void setPkTourist(int pkTourist) {
        this.pkTourist = pkTourist;
    }

    public int getFkCity() {
        return fkCity;
    }

    public void setFkCity(int fkCity) {
        this.fkCity = fkCity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public int getTravelFrequencyInMonths() {
        return travelFrequencyInMonths;
    }

    public void setTravelFrequencyInMonths(int travelFrequencyInMonths) {
        this.travelFrequencyInMonths = travelFrequencyInMonths;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public boolean hasCreditCard() {
        return hasCreditCard;
    }

    public void setHasCreditCard(boolean hasCreditCard) {
        this.hasCreditCard = hasCreditCard;
    }

    public String getIdOfTourist() {
        return idOfTourist;
    }

    public void setIdOfTourist(String idOfTourist) {
        this.idOfTourist = idOfTourist;
    }


    @Override
    public String toString() {
        return "TouristEntity{" + "pkTourist=" + pkTourist + ", fkCity=" + fkCity + ", name=" + name + ", birthday=" + birthday + ", id=" + idOfTourist + ", idType=" + idType + ", travelFrequencyInMonths=" + travelFrequencyInMonths + ", budget=" + budget + ", hasCreditCard=" + hasCreditCard + '}';
    }

}
