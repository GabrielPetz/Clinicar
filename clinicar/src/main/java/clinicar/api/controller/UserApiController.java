package clinicar.api.controller;

import clinicar.api.interfaces.IClinicar;
import clinicar.api.model.User;
import clinicar.web.form.FormUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "user", method = {RequestMethod.GET})
    public List<User> getUsers(){
        return iClinicar.getUsers();
    }

    @RequestMapping(value = "user/role/{role}", method = {RequestMethod.GET})
    public List<User> getUserByRole(@PathVariable Integer role){
        return iClinicar.getUsers();
    }

    @RequestMapping(value = "user/email/{email}", method = {RequestMethod.GET})
    public List<User> getUserByEmail(@PathVariable String email){
        return iClinicar.getUsers();
    }

    @RequestMapping(value = "/user/register", method = {RequestMethod.POST})
    public void registerUser(@ModelAttribute("form") FormUser form){

    }
}
