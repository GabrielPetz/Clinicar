package clinicar.api.jdbc;

import clinicar.api.interfaces.IClinicar;
import clinicar.api.model.User;
import clinicar.api.rowmapper.UserRowMapper;
import clinicar.web.form.FormUser;
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
    public Integer getMaxId() {
        String sql = "select max(usrid) + 1 from users;";

        return clinicarJdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public List<User> getUserByRole(Integer role) {
        String sql = "select * from users, role where rolid = usrrole and usrrole = ?";

        return clinicarJdbcTemplate.query(sql, new Object[]{role}, userRowMapper);
    }

    @Override
    public List<User> getUserByEmail(String email) {
        String sql = "select * from users, role where rolid = usrrole and usremail ilike ?";

        return clinicarJdbcTemplate.query(sql, new Object[]{email}, userRowMapper);
    }

    @Override
    public Integer insertUser(FormUser user) {


        Integer maxId = getMaxId();
        if(maxId == null) maxId = 0;

        String hash = clinicarJdbcTemplate.queryForObject("select crypt(?,gen_salt('bf'));", new Object[]{user.getPassword()}, String.class);
        System.out.println(hash);

        if(getUserByEmail(user.getEmail()).size() > 0){

        } else {
            String sql = "insert into users(usrid, usrname, usremail, usrpassword, usrrole, usractive) values(?,?,?,?,?, true)";
            return clinicarJdbcTemplate.update(sql, new Object[]{maxId, user.getName(), user.getEmail(), hash, user.getRole()});
        }



        return null;

    }

}
