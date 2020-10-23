package thread;

public class Threads {
       static ThreadLocal<Person> person = new ThreadLocal<>();


    public static void main(String[] args) throws InterruptedException {


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run(){
                Person person = new Person("amjad", 22);
                try {
                    Threads.person.set(person);

                    //Thread.sleep(5000);
                    new Test().toString();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.setName("amjad thread");
        thread1.setDaemon(true);
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run(){
                Person pseron = new Person("eyad",2);

                try {
                    Threads.person.set(pseron);

                   // Thread.sleep(5000);
                    new Test().toString();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread2.setName("eyad thread");
        thread2.setDaemon(true);
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println("Eyad This before threads ");
    }

 static   class  Test{
//        static Integer x = 10;
        ThreadLocal<Integer> x = new ThreadLocal<>();
        static Object xLock = new Object();
     static Integer y = 10;
     static Object yLock = new Object();


     @Override
     public String toString() {
            x.set(1);
         for (int i = 0; i < 100; i++)
             x.set(x.get() + 1);

         System.out.println("the x value is  : " + x.get());
         return "";
     }
//         synchronized (xLock) {
//             for (int i = 1; i <= 100; i++)
//                 x++;
//         }
//         System.out.println(Threads.Person.get().name +"  "+ Thread.currentThread().getName() + "  "+ x );
//         return super.toString();
//     }

//
//     public String toString2() {
//         synchronized (yLock) {
//             for (int i = 1; i <= 100; i++)
//                 y++;
//         }
//         System.out.println(Threads.Person.get().name +"  "+ Thread.currentThread().getName() + "  "+ y );
//         return super.toString();
//     }
 }



    public static class Person {
            String name;
            int age;

            public Person(String name, int age) {
                this.name= name;
                this.age= age;
            }

    }
}
