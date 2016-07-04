/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uqam.projet.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.awt.Point;
import java.util.Date;

/**
 *
 * @author Richard Overzee
 */
public class FoodTruck {

    private Date date;
    private String heureDebut;
    private String heureFin;
    private String lieu;
    private Point coordonnees;
    private String camion;
    private String truckid;

    public FoodTruck(Date date, String heureDebut, String heureFin, String lieu, 
            Point coordonnees, String camion, String truckid) {
        this.date = date;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.lieu = lieu;
        this.coordonnees = coordonnees;
        this.camion = camion;
        this.truckid = truckid;
    }
    
    @JsonProperty public Date getDate() { return date; }
    @JsonProperty public String getHeureDebut() { return heureDebut; }
    @JsonProperty public String getHeureFin() { return heureFin; }
    @JsonProperty public String getLieu() { return lieu; }
    @JsonProperty public Point getCoordonnees() { return coordonnees; }
    @JsonProperty public String getCamion() { return camion; }
    @JsonProperty public String getTruckId() { return truckid; }
    
    @Override public String toString() {
        return String.format("%s, %s, %s, %s, %s, %s, %s", date, heureDebut, heureFin, lieu, 
                coordonnees, camion, truckid);
    }
}
