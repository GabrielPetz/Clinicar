package clinicar.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Petz
 * @since 26/10/18
 */
@Controller
public class RedirectController {

    @RequestMapping({"/", ""})
    public void redirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/home");
    }

}
