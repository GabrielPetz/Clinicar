package clinicar.web.data;

import clinicar.web.form.FormUser;
import org.apache.http.NameValuePair;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static clinicar.web.data.DataLoader.setData;

/**
 * @author Petz
 * @since 05/11/18
 */
public class Api {
    public static String setUser(FormUser form){

        String params = "name=" + form.getName() + "&email=" + form.getEmail() + "&password=" + form.getPassword()
                + "&role=" + form.getRole();
        return setData("http://localhost:8080/registrar", params);
    }

}
