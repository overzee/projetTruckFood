/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uqam.projet.tasks;

import ca.uqam.projet.resources.*;

import java.util.*;

import ca.uqam.projet.resources.*;
import ca.uqam.projet.repositories.*;

import java.util.*;
import java.util.stream.*;

import com.fasterxml.jackson.annotation.*;
import java.awt.Point;
import org.jsoup.*;
import org.slf4j.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.web.client.*;

/**
 *
 * @author Richard Overzee
 */

@Component
public class FetchFoodTruckTask {
    
    private static final Logger log = LoggerFactory.getLogger(FetchFoodTruckTask.class);
    private static final String URL = "http://camionderue.com/donneesouvertes/geojson";
    
    @Scheduled(cron="*/2 * * * * ?")
    public void execute() {
        Arrays.asList(new RestTemplate().getForObject(URL, FoodTruck[].class)).stream()
                .map(this::asFoodTruck)
                .map(FoodTruck::toString)
                .forEach(log::info);
                //.peek(c -> log.info(c.toString()));
    }
        
    private FoodTruck asFoodTruck(FoodTruck ft) {
        return new FoodTruck(ft.date, ft.heureDebut, ft.heureFin, ft.lieu,
        ft.coordonnees, ft.camion, ft.truckId);
    }
    

}

class FoodTruck{
  @JsonProperty("Date") Date date; 
  @JsonProperty("Heure_Debut") String heureDebut;
  @JsonProperty("Heure_Fin") String heureFin;
  @JsonProperty("Lieu") String lieu;
  @JsonProperty("coordinates") Point coordonnees;
  @JsonProperty("Camion") String camion;
  @JsonProperty("Truckid") String truckId;

    FoodTruck(Date date, String heureDebut, String heureFin, String lieu, Point coordonnees, String camion, String truckId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
