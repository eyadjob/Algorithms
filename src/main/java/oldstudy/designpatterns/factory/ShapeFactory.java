package oldstudy.designpatterns.factory;

public class ShapeFactory extends AbstractShapeFactory{

    @Override
    Shape getShape(String shapeName) {
        if ( shapeName.toLowerCase().equals("circle")) {
            return new Circle();
        }
        if ( shapeName.toLowerCase().equals("rectangular")) {
            return new Rectangular();
        }
        return null;
    }
}
