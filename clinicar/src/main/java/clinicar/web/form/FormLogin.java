package clinicar.web.form;

/**
 * @author Petz
 * @since 26/10/18
 */
public class FormLogin {
    private String email;
    private String password;

    public FormLogin() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "FormLogin{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
