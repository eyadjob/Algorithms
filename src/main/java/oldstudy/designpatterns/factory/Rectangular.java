package oldstudy.designpatterns.factory;

public class Rectangular implements Shape {


    @Override
    public Shape draw() {
        System.out.println("drawing rectangular ");
        return new Rectangular();
    }
}
