import com.tddair.TddAirApplication;

import fit.ColumnFixture;

public class RegisterMember extends ColumnFixture {

  public String username;
  public String email;
  
  TddAirApplication app = new TddAirApplication();
  public boolean registered() {
    //app.registerMember(username, email);
     //member = app.lookUp(username);
    //return member!=null;
    return false;
  }
  
  public int ytdMiles() {
    return -1;//member.getYtdMiles();
  }
  
  public int balance() {
    return 0;
  }
  public String status() {
    return "";
  }
}
