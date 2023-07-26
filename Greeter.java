import java.util.Locale;
import java.util.ResourceBundle;
import java.time.LocalDate;


public class Greeter {

  private Locale locale;
  private String name;
  private LocalDate birthday;

  public Greeter(String language, String country, String name, LocalDate birthday) {
    locale = new Locale(language, country);
    this.name = name;
    this.birthday = birthday;
  }

  public String sayHello() {
    ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);
    return messages.getString("greeting") + ", " + "<strong>" + name.toUpperCase() + "</strong>";
  }

  public boolean isBirthday() {
    LocalDate today = LocalDate.now();
    return today.getMonth() == birthday.getMonth() && today.getDayOfMonth() == birthday.getDayOfMonth();
  }

  public static void main(String[] args) {
    String language = args[0];
    String country = args[1];
    String name = args[2] + args[3];
    LocalDate birthday = LocalDate.parse(args[5]);
    Greeter greeter = new Greeter(language, country, name, birthday);
    System.out.println(greeter.sayHello());
    if (greeter.isBirthday()) {
       System.out.println("Happy Birthday!");
    }
  }
}
