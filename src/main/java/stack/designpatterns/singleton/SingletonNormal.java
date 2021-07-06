package stack.designpatterns.singleton;

public class SingletonNormal {

    private static SingletonNormal sing;

    private SingletonNormal(){};


    public static SingletonNormal getInstance() {

        if ( sing == null ) {
            synchronized (SingletonNormal.class) {

                if ( sing == null )
                    sing = new SingletonNormal();
            }
        }
        return sing;
    }
}
