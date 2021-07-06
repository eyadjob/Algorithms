package stack.paypay;

public class IslandOfIsolation
{

    public static void main(String[] args) {
      new IslandOfIsolation().Test();

    }

    public void Test() {
        Human human1 = new Human("Shraman");
        Human human2 = new Human("Debanjan");
//        human1.name=human2.name;
        human2.name=human1.name;

        human1=null;//Nullifying the first object

//        human2=null;//nullifying the second object.

        System.out.println(human2.name);

        System.gc();//calling the garbage collector.
    }


    class Human
    {
        @Override
        protected void finalize() throws Throwable
        {
            System.out.println("Garbage collector in action! Deleted one object!");
        }
        String name;
        Human(String name)
        {
            this.name=name;
        }
    }

}