import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import shapes.Circle;
import shapes.Square;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        //define container
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //retrieve bean
        Circle circle = (Circle) context.getBean("circle");
        Square square =(Square) context.getBean("square");
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        circle.setRadius(length);
        square.setLength(length);
        System.out.println("Area of Circle = "+circle.getArea());
        System.out.println("Area of Square = "+square.getArea());

    }
}