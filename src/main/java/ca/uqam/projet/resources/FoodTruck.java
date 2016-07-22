/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uqam.projet.resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Phoenix
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodTruck {
    
    private String name;
    private String description;
    private String date;
    private String heureDebut;
    private String heureFin;
    private String lieu;
    private String camion;
    private String truckid;
    private String longitude;
    private String latitude;
    
    public FoodTruck() {
        
    }
    
    public FoodTruck(String name, String description, String date, String heureDebut, 
            String heureFin, String lieu, String camion, String truckid, String longitude,
            String latitude) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.lieu = lieu;
        this.camion = camion;
        this.truckid = truckid;
        this.longitude = longitude;
        this.latitude = latitude;
    }
    
    @Override
    public String toString() {
        return "Name: " + getName() + '\n' +
            "Description: " + getDescription() + '\n' +
            "Date: " + getDate() + '\n' +
            "Heure_debut: " + getHeureDebut() + '\n' +
            "Heure_fin: "+ getHeureFin() + '\n' +
            "Lieu: " + getLieu() + '\n' +
            "Camion: " + getCamion() + '\n' +
            "Truckid: " + getTruckid() + '\n'+
            "Longitude: " + getLongitude() + '\n'+
            "Latitude: " + getLatitude() + '\n';
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the heureDebut
     */
    public String getHeureDebut() {
        return heureDebut;
    }

    /**
     * @param heureDebut the heureDebut to set
     */
    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    /**
     * @return the heureFin
     */
    public String getHeureFin() {
        return heureFin;
    }

    /**
     * @param heureFin the heureFin to set
     */
    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }

    /**
     * @return the lieu
     */
    public String getLieu() {
        return lieu;
    }

    /**
     * @param lieu the lieu to set
     */
    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    /**
     * @return the camion
     */
    public String getCamion() {
        return camion;
    }

    /**
     * @param camion the camion to set
     */
    public void setCamion(String camion) {
        this.camion = camion;
    }

    /**
     * @return the truckid
     */
    public String getTruckid() {
        return truckid;
    }

    /**
     * @param truckid the truckid to set
     */
    public void setTruckid(String truckid) {
    this.truckid = truckid;
   }
    
    public String getLatitude(List<Double> coordinates){
        return latitude = Double.toString(coordinates.get(0));
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * @return the latitude
     */
    public String getLatitude() {
        return latitude;
    }
}
