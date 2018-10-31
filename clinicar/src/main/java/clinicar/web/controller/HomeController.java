package clinicar.web.controller;

import io.swagger.annotations.Api;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Petz
 * @since 26/10/18
 */
@Api(produces = "application/json", tags = {"homepage"})
@Controller
@RequestMapping("")
public class HomeController {



    @RequestMapping("/home")
    public String home(Model model, HttpServletRequest request, HttpServletResponse response) {
        System.out.println(SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName());
        return "home";
    }

    @RequestMapping("/admin")
    public String admin(Model model, HttpServletRequest request, HttpServletResponse responsee) {

        System.out.println(SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName());
        return "admin";
    }

//
//    @RequestMapping("/index")
//    public String index(Model model){
//        return "index";
//    }
}
