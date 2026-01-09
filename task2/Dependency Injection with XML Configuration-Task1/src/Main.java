import Shapes.Circle;
import Shapes.Draw2D;
import Shapes.Draw3D;
import Shapes.Square;

public class Main {
    public static void main(String[] args) {
        container
        Draw3D drawCircle = new Draw3D();
        Draw2D drawSquare = new Draw2D();
       Circle circle = new Circle(drawCircle);
       circle.draw();
       Square square = new Square();
       square.setDrawer(drawSquare);
       square.draw();
    }
}