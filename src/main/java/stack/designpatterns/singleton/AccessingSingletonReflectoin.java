package stack.designpatterns.singleton;

import java.lang.reflect.Constructor;

public class AccessingSingletonReflectoin {


        public static void main(String[] args) {
            SingletonNormal instanceOne = SingletonNormal.getInstance();
            SingletonNormal instanceTwo = null;
            try {
                Constructor[] constructors = SingletonNormal.class.getDeclaredConstructors();
                for (Constructor constructor : constructors) {
                    //Below code will destroy the singleton pattern
                    constructor.setAccessible(true);
                    instanceTwo = (SingletonNormal) constructor.newInstance();
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(instanceOne.hashCode());
            System.out.println(instanceTwo.hashCode());
        }
}
