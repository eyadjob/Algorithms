package amaniStudy;

public class HelloWorld {

    public static void main(String[] args) {
 class Main {
   Object message(){
     return "Hello!";
   }
   public static void main(String[] args) {
     System.out.print(new Main().message());
     System.out.print(new Main2().message());
   }
 }
class Main2 extends Main {
  String message(){
    return "World!";
  }
}
    }
}
