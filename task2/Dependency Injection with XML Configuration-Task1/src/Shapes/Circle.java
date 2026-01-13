package Shapes;

public class Circle implements Shape {
    Draw3D Drawer;


    public  Circle(Draw3D Drawer){
        this.Drawer=Drawer;
    }
    @Override
    public void draw() {
        Drawer.draw("Circle");

    }
}
