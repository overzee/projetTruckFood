package ca.uqam.projet.repositories;

import ca.uqam.projet.resources.Citation;
import ca.uqam.projet.resources.Features;
import ca.uqam.projet.resources.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ethienneroy on 2016-07-20.
 */
public class FoodtruckRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

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

    public List<Citation> findAll() {
        return jdbcTemplate.query(FIND_ALL_STMT, new CitationRowMapper());
    }

    private static final String FIND_BY_ID_STMT =
            " select"
                    + "     id"
                    + "   , auteur"
                    + "   , contenu"
                    + " from"
                    + "   citations"
                    + " where"
                    + "   id = ?"
            ;

    public Citation findById(int id) {
        return jdbcTemplate.queryForObject(FIND_BY_ID_STMT, new Object[]{id}, new CitationRowMapper());
    }

    private static final String INSERT_STMT =
            " insert into foodTruck (id,name,description,fromdate,heureDebut," 
                    + "heureFin,lieu,camion," 
                    + "truckId,longitude,latitude)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
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
