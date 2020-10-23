package oldstudy.designpatterns.factory;

public class Circle implements  Shape {

    String shape = "Circle";

    @Override
    public Shape draw() {
        System.out.println("inside draw for circle");
       return new Circle();
    }
}
