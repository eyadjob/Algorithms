package designpatterns.factory.test;

public class Square implements Shape {
    @Override
    public Shape draw() {
        return new Square();
    }
}
