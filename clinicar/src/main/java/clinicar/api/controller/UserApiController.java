package clinicar.api.controller;

import clinicar.api.interfaces.IClinicar;
import clinicar.api.model.User;
import clinicar.web.form.FormUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @author Petz
 * @since 26/10/18
 */

@RestController
@RequestMapping("/clinicar")
public class UserApiController {

    @Autowired
    private IClinicar iClinicar;

    @RequestMapping(value = "usuario", method = {RequestMethod.GET})
    public List<User> getUsers(){
        return iClinicar.getUsers();
    }

    @RequestMapping(value = "usuario/role/{role}", method = {RequestMethod.GET})
    public List<User> getUserByRole(@PathVariable Integer role) {
        return iClinicar.getUsers();
    }

    @RequestMapping(value = "usuario/email/{email}", method = {RequestMethod.GET})
    public List<User> getUserByEmail(@PathVariable String email) {
        return iClinicar.getUsers();
    }

    @RequestMapping(value = "/usuario", method = {RequestMethod.POST})
    public Integer registerUser(@ModelAttribute FormUser form, HttpServletRequest request) throws ServletException, IOException {

        return iClinicar.insertUser(form);
    }
}
