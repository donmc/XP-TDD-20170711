import com.tddair.Member;
import com.tddair.TddAirApplication;

import fit.ColumnFixture;

public class RegisterMember extends ColumnFixture {

  public String username;
  public String email;
  private Member member;

  TddAirApplication app = new TddAirApplication();

  public boolean registered() {
    app.registerMember(username, email);
    member = app.lookupMember(username);
    return member!=null;
  }

  public int ytdMiles() {
    return member.getYtdMiles();
  }

  public int balance() {
    return member.getBalanceMiles();
  }

  public String status() {
    return member.getStatus().toString();
  }
}
