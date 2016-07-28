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
                    + "   bixi"
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

    public int insert(Bixi bixi) {
            return jdbcTemplate.update(conn -> {
                PreparedStatement ps = conn.prepareStatement(INSERT_STMT);
                for(int i = 0; i < bixi.sizeOfStations(); i++){
                    ps.setString(1, bixi.getStationFromStations(bixi.getStations(), i).getId());
                    ps.setString(2, bixi.getStationFromStations(bixi.getStations(), i).getName());
                    ps.setString(3, bixi.getStationFromStations(bixi.getStations(), i).getTerminalName());
                    ps.setString(4, bixi.getStationFromStations(bixi.getStations(), i).getLastCommWithServer());
                    ps.setString(5, bixi.getStationFromStations(bixi.getStations(), i).getLongi());
                    ps.setString(6, bixi.getStationFromStations(bixi.getStations(), i).getLat());
                    ps.setString(7, bixi.getStationFromStations(bixi.getStations(), i).getInstalled());
                    ps.setString(8, bixi.getStationFromStations(bixi.getStations(), i).getInstallDate());
                    ps.setString(9, bixi.getStationFromStations(bixi.getStations(), i).getRemovalDate());
                    ps.setString(10, bixi.getStationFromStations(bixi.getStations(), i).getTemporary());
                    ps.setString(11, bixi.getStationFromStations(bixi.getStations(), i).getPublicxml());
                    ps.setString(12, bixi.getStationFromStations(bixi.getStations(), i).getNbBikes());
                    ps.setString(13, bixi.getStationFromStations(bixi.getStations(), i).getNbEmptyDocks());
                    ps.setString(14, bixi.getStationFromStations(bixi.getStations(), i).getLastUpdateTime());
                    ps.executeUpdate();
                }
                return ps;
            });
    }
}


