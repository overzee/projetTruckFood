package ca.uqam.projet.repositories;

import ca.uqam.projet.resources.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * Created by ethienneroy on 2016-07-20.
 */
@Component
public class FoodtruckRepository {

    @Autowired private JdbcTemplate jdbcTemplate;
    
    private static final String FIND_ALL_STMT =
            " select"
                    + "   ,name"
                    + "   ,description"
                    + "   ,fromdate"
                    + "   ,heureDebut"
                    + "   ,heureFin"
                    + "   ,lieu"
                    + "   ,camion"
                    + "   ,truckId"
                    + "   ,longitude"
                    + "   ,latitude"
                    + " from"
                    + "   foodTruck"
            ;

    private static final String INSERT_STMT =
            " insert into foodTruck (truckId, name,description,"
                    + "fromdate,heureDebut," 
                    + "heureFin,lieu,camion," 
                    + "longitude,latitude)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
                    + " on conflict do nothing"
    ;

    public int insert(Features features) {
        return jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(INSERT_STMT);
            ps.setString(1, features.getFeatureFromFeatures(features.getFeatures()).
                    getProperties().getName());
            ps.setString(2, features.getFeatureFromFeatures(features.getFeatures()).
                    getProperties().getDescription());
            ps.setString(3, features.getFeatureFromFeatures(features.getFeatures()).
                    getProperties().getDate());
            ps.setString(4, features.getFeatureFromFeatures(features.getFeatures()).
                    getProperties().getHeureDebut());
            ps.setString(5, features.getFeatureFromFeatures(features.getFeatures()).
                    getProperties().getHeureFin());
            ps.setString(6, features.getFeatureFromFeatures(features.getFeatures()).
                    getProperties().getLieu());
            ps.setString(7, features.getFeatureFromFeatures(features.getFeatures()).
                    getProperties().getCamion());
            ps.setString(8, features.getFeatureFromFeatures(features.getFeatures()).
                    getProperties().getTruckid());
            ps.setString(9, features.getFeatureFromFeatures(features.getFeatures()).
                    getGeometry().getLongitude());
            ps.setString(10, features.getFeatureFromFeatures(features.getFeatures()).
                    getGeometry().getLatitude());
            return ps;
        });
    }
}

/**class FoodTruckRowMapper implements RowMapper<Features> {
    public Features mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Features(
                rs.getInt("id")
                , rs.getString("auteur")
                , rs.getString("contenu")
        );
    }
}*/
