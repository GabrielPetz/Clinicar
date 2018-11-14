package clinicar.web.controller;

import clinicar.api.interfaces.IClinicar;
import clinicar.api.model.User;
import clinicar.web.form.FormUser;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

import static clinicar.web.data.Api.setUser;
import static clinicar.web.data.DataLoader.setData;

/**
 * @author Petz
 * @since 26/10/18
 */
@Api(produces = "application/json", tags = {"user"})
@Controller
@RequestMapping("")
public class UserController {

    @Autowired
    private IClinicar iClinicar;

    @RequestMapping(value = "/registrar", method = {RequestMethod.GET})
    public String home(Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("form", new FormUser());
        return "register";

    }

    @RequestMapping(value = "/registrar", method = {RequestMethod.POST})
    public void registrar(@ModelAttribute("form") FormUser form, HttpServletRequest request, HttpServletResponse response) {
       setUser(form);
    }

    @RequestMapping("/usuario")
    public String userInfo(Model model){



        return "userinfo";
    }

}
