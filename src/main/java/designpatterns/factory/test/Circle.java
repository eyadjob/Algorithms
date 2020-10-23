package designpatterns.factory.test;

public class Circle implements Shape{


    @Override
    public Shape draw() {
        return new Circle();
    }
}
