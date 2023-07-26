import java.util.Locale;
import java.util.ResourceBundle;

public class Greeter {

  private Locale locale;
  private String name;
  private int userid;

  public Greeter(String language, String country, String name, int userid) {
    locale = new Locale(language, country);
    this.name = name;
    this.userid = userid;
  }

  public String sayHello() {
    ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);
    return messages.getString("greeting") + ", " + "<strong>" + name.toUpperCase() + "</strong>" + " #" + String.valueOf(userid);
  }

  public static void main(String[] args) {
    String language = args[0];
    String country = args[1];
    String name = args[2] + " " + args[3];
    int userid = Integer.parseInt(args[4]);
    Greeter greeter = new Greeter(language, country, name, userid);
    System.out.println(greeter.sayHello());
  }
}
