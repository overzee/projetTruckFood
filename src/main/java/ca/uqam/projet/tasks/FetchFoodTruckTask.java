/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uqam.projet.tasks;

import ca.uqam.projet.resources.*;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import javafx.scene.input.DataFormat;
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

    @Autowired private FoodtruckRepository repository;
    
    @Scheduled(cron="*/120 * * * * ?")
    public void execute() throws IOException {
        Arrays.asList(new RestTemplate().getForObject(URL, Features.class)).stream()
                .peek(c -> log.info(c.toString()))
                .forEach(repository::insert)
                ;
        ;
        //for(int i = 0, ){
        //}
    }

//    GET /horaires-camions?du=2016-05-08&au=2016-05-15
    /* Must return a JSON format string */
    /**private final String host = "jdbc:postgresql:projectdatabase";
    private final String username = "postgres";
    private final String password = "postgres";
    private final DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
    @RequestMapping("/getTrucks")
    public String getTrucks(@RequestParam(value="du")String start,@RequestParam(value="au")String end){
        ArrayList<Object> foodtrucks = new ArrayList<>();
        String value = "you called function with params : " + start + "  ||  " + end;

        java.sql.Connection conn = null;
        try {
            conn = DriverManager.getConnection( host, username, password );
            Statement st = conn.createStatement();
            String query = "SELECT * FROM foodtruck WHERE fromDate > '"+ start +"' AND fromDate <= '" + end + "'";
            System.out.println(query);
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                System.out.println(rs.getString(2));//get description
                //create truck list -> send to JSON -> return
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return value;
    }*/
}


//    List<Product> products = someProductService.list();
//    String json = new Gson().toJson(products);
//
//response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().write(json);
//        }


