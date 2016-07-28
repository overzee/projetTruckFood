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
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.*;

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
        
    }

//    
   



