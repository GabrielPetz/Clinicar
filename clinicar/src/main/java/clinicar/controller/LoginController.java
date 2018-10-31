package clinicar.controller;

import clinicar.web.form.FormLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Petz
 * @since 28/08/18
 */
@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    private final RequestCache requestCache = new HttpSessionRequestCache();

    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String login(@ModelAttribute FormLogin loginForm, Model model) {
        model.addAttribute("role", SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName());
        return "login";
    }

    @RequestMapping("/loginsuccess")
    public void loginsuccess(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("/");
        } catch (IOException ex){
            System.out.println("ERRO:"+ ex.getMessage());
        }
    }
}


