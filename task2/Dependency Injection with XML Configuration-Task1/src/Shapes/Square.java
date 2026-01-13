package Shapes;

public class Square implements Shape {
    Draw2D Drawer;


    public void setDrawer(Draw2D drawer) {
        this.Drawer = drawer;
    }
    @Override
    public void draw() {
      Drawer.draw("Square");
    }
}
