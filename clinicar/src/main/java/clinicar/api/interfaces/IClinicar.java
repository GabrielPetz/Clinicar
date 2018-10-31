package clinicar.api.interfaces;

import clinicar.api.model.User;

import java.util.List;

/**
 * @author Petz
 * @since 31/10/18
 */
public interface IClinicar {

    List<User> getUsers();

    List<User> getUserByRole(Integer role);

    List<User> getUserByEmail(String email);

    Integer insertUser(User user);

    Integer getMaxId();

}
