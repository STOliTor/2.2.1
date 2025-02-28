package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();

   void addCar(Car car);
   List<Car> listCars();

   User findUserByCarModelAndSeries(String model, String series);
}
