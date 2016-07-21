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
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.Point;
import java.io.IOException;
import org.jsoup.*;
import org.slf4j.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.*;

/**
 *
 * @author Richard Overzee
 */
@RestController
@Component
@Controller
public class FetchFoodTruckTask {
    
    private static final Logger log = LoggerFactory.getLogger(FetchFoodTruckTask.class);
    private static final String URL = "http://camionderue.com/donneesouvertes/geojson";

//    @Scheduled(cron="*/120 * * * * ?")
//    public void execute() throws IOException {
//        System.out.println(URL);
//        System.out.println(Arrays.asList(new RestTemplate().getForObject(URL, Features.class)).stream());
//        //Features myObjects = mapper.readValue(URL,Features.class);
//        Arrays.asList(new RestTemplate().getForObject(URL, Features.class)).stream()
//                .map(Features::toString)
//                .forEach(log::info);
//        ;
//    }

//    GET /horaires-camions?du=2016-05-08&au=2016-05-15
    /* Must return a JSON format string */
    @RequestMapping("/getTrucks")
    public String getTrucks(@RequestParam(value="du")String start,@RequestParam(value="au")String end){
        System.out.println("you called function with params : " + start + "  ||  " + end);
        return "you called function with params : " + start + "  ||  " + end;
    }
}



