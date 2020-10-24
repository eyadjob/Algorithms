package oldstudy.designpatterns.factory;

import oldstudy.designpatterns.singleton.SingletonInnerClass;

public class Test {


    public static void main(String[] args) {

        AbstractShapeFactory shapeFactory = FactoryProducer.getFactory("shape");

        shapeFactory.getShape("circle").draw();
        SingletonInnerClass.getInstance();
    }
}

