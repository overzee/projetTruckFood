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
                    + "     id"
                    + "   , auteur"
                    + "   , contenu"
                    + " from"
                    + "   citations"
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
            " insert into citations (id, auteur, contenu)"
                    + " values (?, ?, ?)"
                    + " on conflict do nothing"
            ;

//    public int insert(Features features) {
//        return jdbcTemplate.update(conn -> {
//            PreparedStatement ps = conn.prepareStatement(INSERT_STMT);
//            ps.setInt(1, citation.getId());
//            ps.setString(2, citation.getAuteur());
//            ps.setString(3, citation.getContenu());
//            return ps;
//        });
//    }
}

//class FoodTruckRowMapper implements RowMapper<Properties> {
//    public Properties mapRow(ResultSet rs, int rowNum) throws SQLException {
////        return new Properties(
////                rs.getInt("id")
////                , rs.getString("auteur")
////                , rs.getString("contenu")
////        );
//    }
//}
