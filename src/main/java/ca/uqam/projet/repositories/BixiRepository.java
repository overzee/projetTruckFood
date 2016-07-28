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
 * Created by jeremie decaire
 */
@Component
public class BixiRepository {

    @Autowired private JdbcTemplate jdbcTemplate;
    
    private static final String FIND_ALL_STMT =
            " select"
                    + "   ,id"
                    + "   ,name"
                    + "   ,terminalName"
                    + "   ,lastCommWithServer"
                    + "   ,latitude"
                    + "   ,longitude"
                    + "   ,installed"
                    + "   ,locked"
                    + "   ,installDate"
                    + "   ,removalDate"
                    + "   ,temporary"
                    + "   ,public"
                    + "   ,nbBikes"
                    + "   ,nbEmptyDocks"
                    + "   ,lastUpdateTime"
                    + " from"
                    + "   foodTruck"
            ;

    private static final String INSERT_STMT =
            " insert into station(id, name,terminalName,"
                    + "lastCommWithServer" 
                    + "latitude,longitude,installed," 
                    + "locked,installDate,removalDate"
                    + "temporary,public)"
                    + "nbBikes,nbEmptyDocks,lastUpdateTime)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
                    + " on conflict do nothing"
    ;

    public int insert(Station station) {
            return jdbcTemplate.update(conn -> {     
                PreparedStatement ps = conn.prepareStatement(INSERT_STMT);            
                for (int i = 0; i < station.sizeOfstation(); i++){
                    ps.setString(1, station.getFeatureFromstation(station.getstation(), i).
                            getProperties().getId());
                    ps.setString(2, station.getFeatureFromstation(station.getstation(), i).
                            getProperties().getName());
                    ps.setString(3, station.getFeatureFromstation(station.getstation(), i).
                            getProperties().getTerminalName());
                    ps.setString(4, station.getFeatureFromstation(station.getstation(), i).
                            getProperties().getLastCommitWithServer());
                    ps.setString(9, station.getFeatureFromstation(station.getstation(), i).
                            getGeometry().getLongitude(station.getFeatureFromstation(station.getstation(), i).
                            getGeometry().getCoordinates()));
                    ps.setString(10, station.getFeatureFromstation(station.getstation(), i).
                            getGeometry().getLatitude(station.getFeatureFromstation(station.getstation(), i).
                            getGeometry().getCoordinates()));
                    ps.setString(5, station.getFeatureFromstation(station.getstation(), i).
                            getProperties().getInstalled());
                    ps.setString(6, station.getFeatureFromstation(station.getstation(), i).
                            getProperties().getLocked());
                    ps.setString(7, station.getFeatureFromstation(station.getstation(), i).
                            getProperties().getInstallDate());
                    ps.setString(8, station.getFeatureFromstation(station.getstation(), i).
                            getProperties().getRemovalDate());
                    ps.setString(8, station.getFeatureFromstation(station.getstation(), i).
                            getProperties().getTemporary());
                    ps.setString(8, station.getFeatureFromstation(station.getstation(), i).
                            getProperties().getPublic());
                    ps.setString(8, station.getFeatureFromstation(station.getstation(), i).
                            getProperties().getNbBikes());
                    ps.setString(8, station.getFeatureFromstation(station.getstation(), i).
                            getProperties().getNbEmptyDocks());
                    ps.setString(8, station.getFeatureFromstation(station.getstation(), i).
                            getProperties().getLastUpdateTime());
                    
                    ps.executeUpdate();
                }
                return ps;
            });
    }
}


