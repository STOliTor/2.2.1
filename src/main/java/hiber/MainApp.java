package hiber;

import hiber.config.AppConfig;
import hiber.dao.UserDaoImp;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import hiber.service.UserServiceImp;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//
//      userService.addCar(new Car("Toyota", "xls"));
//      userService.addCar(new Car("BMW", "x5"));

      User user1 =new User("King", "Dyson", "fen@mail.ru");
      User user2 =new User("Lord", "Cold", "frost@mail.ru");

      Car car1 = new Car("Toyota", "Supra");
      Car car2 = new Car("BMW", "X5");
      user1.setCar(car1);
      user2.setCar(car2);

      userService.add(user1);
      userService.add(user2);

      User user = userService.getUserByCarModelAndSeries("Toyota", "Supra");
      System.out.println(user.toString());

//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }
//
//      List<Car> cars = userService.listCars();
//      for (Car car : cars) {
//         System.out.println("Id = "+car.getId());
//         System.out.println("model = "+car.getModel());
//         System.out.println("series = "+car.getSeries());
//      }

      context.close();
   }
}
