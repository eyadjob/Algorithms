package stack.designpatterns.factory.test;

public class ShapeFactory extends AbstractShape {


    @Override
    public Shape getShape(String shapeName) {
        if ( shapeName.equals("circle")) {
            return new Circle();
        } else if (shapeName.equals("square")) {
            return new Square();
        }
        return null;
    }
}
