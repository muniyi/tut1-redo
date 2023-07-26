import java.util.Locale;
import java.util.ResourceBundle;
import java.time.LocalDate;


public class Greeter {

  private Locale locale;
  private String name;
  private int userid;
  private LocalDate birthday;

  public Greeter(String language, String country, String name, int userid, LocalDate birthday) {
    locale = new Locale(language, country);
    this.name = name;
    this.userid = userid;
    this.birthday = birthday;
  }

  public String sayHello() {
    ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);
    return messages.getString("greeting") + ", " + "<strong>" + name.toUpperCase() + "</strong>" + " #" + String.valueOf(userid);
  }

  public boolean isBirthday() {
    LocalDate today = LocalDate.now();
    return today.getMonth() == birthday.getMonth() && today.getDayOfMonth() == birthday.getDayOfMonth();
  }

  public static void main(String[] args) {
    String language = args[0];
    String country = args[1];
    String name = args[2] + " " + args[3];
    int userid = Integer.parseInt(args[4]);
    LocalDate birthday = LocalDate.parse(args[5]);
    Greeter greeter = new Greeter(language, country, name, userid, birthday);
    System.out.println(greeter.sayHello());
    if (greeter.isBirthday()) {
       System.out.println("Happy Birthday!");
    }
  }
}
