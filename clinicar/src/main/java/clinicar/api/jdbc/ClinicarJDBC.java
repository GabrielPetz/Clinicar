package clinicar.api.jdbc;

import clinicar.api.interfaces.IClinicar;
import clinicar.api.model.User;
import clinicar.api.rowmapper.UserRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Petz
 * @since 31/10/18
 */
@Repository
@Component("clinicarDB")
public class ClinicarJDBC implements IClinicar {

    @Autowired
    private JdbcTemplate clinicarJdbcTemplate;

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

    private UserRowMapper userRowMapper = new UserRowMapper();

    @Override
    public List<User> getUsers() {
        String sql = "select * from users, role where rolid = usrrole";

        return clinicarJdbcTemplate.query(sql, userRowMapper);
    }

    @Override
    public Integer getMaxId(){
        String sql = "";
    }

    @Override
    public List<User> getUserByRole(Integer role) {
        String sql = "select * from users, role where rolid = usrrole and usrrole = ?";

        return clinicarJdbcTemplate.query(sql, new Object[]{role}, userRowMapper);
    }

    @Override
    public List<User> getUserByEmail(String email) {
        String sql = "select * from users, role where rolid = usrrole and usremail = ?";

        return clinicarJdbcTemplate.query(sql, new Object[]{email}, userRowMapper);
    }

    @Override
    public Integer insertUser(User user) {

        String sql = "insert into users()";

        return clinicarJdbcTemplate.update(sql);
    }

}
