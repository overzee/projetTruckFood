/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uqam.projet.tasks;

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
 * @author jeremie decaire
 */
@RestController
@Component
@Controller
public class FetchBixiTask {
    
    private static final Logger log = LoggerFactory.getLogger(FetchBixiTask.class);
    private static final String URL = "https://montreal.bixi.com/data/bikeStations.xml";

    @Autowired private BixiRepository repository;
    
    @Scheduled(cron="*/120 * * * * ?")
    public void execute() throws IOException {
        /**Arrays.asList(new RestTemplate().getForObject(URL, Bixi.class)).stream()
            //.peek(c -> log.info(c.toString()))
            .forEach(repository::insert)
            ;*/
    }   

//  GET /station bixi
  /* Must return a JSON format string */
    /*
  private final String host = "jdbc:postgresql:projectdatabase";
  private final String username = "postgres";
  private final String password = "postgres";
  
  @RequestMapping("/getBixi")
  public String getBixi(@RequestParam(value="latitude")String lati,@RequestParam(value="longitude")String longi){
      ArrayList<Object> bixi = new ArrayList<>();
      java.sql.Connection conn = null;
      String valueBixi;
      try {
          conn = DriverManager.getConnection( host, username, password );
          Statement st = conn.createStatement();
          
          String query = "SELECT * FROM geotable  WHERE ST_DWithin(geocolumn, 'POINT("+ lati +" "+ longi +")', 200.0)";
          out.println(query);
          ResultSet rs = st.executeQuery(query);
          while (rs.next()) {
              //bixi.add(new Station(rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(1), rs.getString(9), rs.getString(10)
            		  //, rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15)));
          }
          rs.close();
          st.close();
      } catch (SQLException e) {
          e.printStackTrace();
      }

      valueBixi = parseToJSON(bixi);
//      System.out.println(Response.ok(value).build().toString());

      return valueBixi;
  }
  
  private String parseToJSON(ArrayList<Object> bixi) {
      JSONArray bixiJSON = new JSONArray(bixi);
      String value = bixiJSON.toString(4);
      if(bixi.size()>0)
          return value;
      else return "No data matched your request.";
  }
*/
}




