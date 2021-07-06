package designpatterns.factory;

public class FactoryProducer{


        public static AbstractShapeFactory getFactory(String type) {

            if ( type.toLowerCase().equals("shape"))
            {
                return new ShapeFactory();
            }
            return null;
        }
}
