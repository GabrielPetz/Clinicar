package clinicar.api.rowmapper;

import clinicar.api.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * @author Petz
 * @since 31/10/18
 */
public class UserRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {

        User user = new User();

        user.setUsrid(rs.getInt("usrid"));
        user.setUsrname(rs.getString("usrname"));
        user.setUsremail(rs.getString("usremail"));
        user.setUsrbirthday(rs.getObject("usrbirthday", LocalDate.class));
        user.setRoldesc(rs.getString("roldesc"));
        user.setUsrrole(rs.getInt("usrrole"));

        return user;
    }
}
