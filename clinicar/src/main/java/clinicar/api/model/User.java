package clinicar.api.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Petz
 * @since 31/10/18
 */
public class User {

   private Integer usrid;
   private String usremail;
   private String usrname;
   private LocalDate usrbirthday;
   private Integer usrrole;
   private String roldesc;

   public User() {
   }

   public Integer getUsrrole() {
      return usrrole;
   }

   public void setUsrrole(Integer usrrole) {
      this.usrrole = usrrole;
   }

   public Integer getUsrid() {
      return usrid;
   }

   public void setUsrid(Integer usrid) {
      this.usrid = usrid;
   }

   public String getUsremail() {
      return usremail;
   }

   public void setUsremail(String usremail) {
      this.usremail = usremail;
   }

   public String getUsrname() {
      return usrname;
   }

   public void setUsrname(String usrname) {
      this.usrname = usrname;
   }

   public LocalDate getUsrbirthday() {
      return usrbirthday;
   }

   public void setUsrbirthday(LocalDate usrbirthday) {
      this.usrbirthday = usrbirthday;
   }

   public String getRoldesc() {
      return roldesc;
   }

   public void setRoldesc(String roldesc) {
      this.roldesc = roldesc;
   }
}
