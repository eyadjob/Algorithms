package study.polymorphisim;

public class Sheep implements Mamal{


    @Override
    public void eat() {
        System.out.println("eating grass now");
    }

    @Override
   public  void makeSound() {
        System.out.println("Ma'a");
    }

    public static void main(String[] args) {


    }
}
