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
import org.json.JSONArray;
import org.jsoup.*;
import org.slf4j.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.*;

import static java.lang.System.out;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;
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
    private final String host = "jdbc:postgresql:projectdatabase";
    private final String username = "postgres";
    private final String password = "postgres";
    private final DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
    @RequestMapping("/getTrucks")
    public String getTrucks(@RequestParam(value="du")String start,@RequestParam(value="au")String end){
        ArrayList<Object> foodtrucks = new ArrayList<>();
        java.sql.Connection conn = null;
        String value;
        try {
            conn = DriverManager.getConnection( host, username, password );
            Statement st = conn.createStatement();
            String query = "SELECT * FROM foodtruck WHERE fromDate > '" + start + "' AND fromDate <= '" + end + "'";
            out.println(query);
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                foodtrucks.add(new FoodTruck(rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(1), rs.getString(9), rs.getString(10)));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        value = parseToJSON(foodtrucks);
//        System.out.println(Response.ok(value).build().toString());

        return value;
    }



    private String parseToJSON(ArrayList<Object> foodtrucks) {
        JSONArray trucksJSON = new JSONArray(foodtrucks);
        String value = trucksJSON.toString(4);
        if(foodtrucks.size()>0)
            return value;
        else return "No data matched your request.";
    }
}


//    List<Product> products = someProductService.list();
//    String json = new Gson().toJson(products);
//
//response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().write(json);
//        }


