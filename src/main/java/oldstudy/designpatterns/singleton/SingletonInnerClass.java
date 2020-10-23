package oldstudy.designpatterns.singleton;

public class SingletonInnerClass {

    private SingletonInnerClass(){};

    private static class SingletonHelper {
        private static final SingletonInnerClass intance = new SingletonInnerClass();

    }

    public static SingletonInnerClass getInstance() {
        return SingletonHelper.intance;
    }
}
