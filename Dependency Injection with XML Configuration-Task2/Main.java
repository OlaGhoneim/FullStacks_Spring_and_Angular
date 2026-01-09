import System.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Vehicle car = context.getBean("car", Vehicle.class);
        car.setBrand("BMW");
        car.saveData();
        Vehicle Plane = context.getBean("plane", Vehicle.class);
        Plane.setBrand("Toytaa");
        Plane.saveData();

        ((ClassPathXmlApplicationContext) context).close();





    }
}