package clinicar.web.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Petz
 * @since 26/10/18
 */
@Api(produces = "application/json", tags = {"homepage"})
@Controller
@RequestMapping("")
public class HomeController {

    @RequestMapping("/home")
    public String home(Model model) {
        return "home";
    }

    @RequestMapping("/admin")
    public String admin(Model model) {
        return "home";
    }

//
//    @RequestMapping("/index")
//    public String index(Model model){
//        return "index";
//    }
}
