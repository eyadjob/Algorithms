package oldstudy.study.polymorphisim;

public class Cat implements Mamal {


    @Override
    public void eat() {
        System.out.println("eating meat now");
    }

    @Override
    public void makeSound(){
        System.out.println("meow");
    }
}
