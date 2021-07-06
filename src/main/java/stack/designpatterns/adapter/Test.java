package stack.designpatterns.adapter;

public class Test {

    public static void main(String[] args) {

        testClassMethod();
        testObject();
    }

    private static void testObject() {
        SocketInterface sockObject = new SocketInterfaceImpl();
        Volt v3 = getVolt(sockObject,3);
        Volt v12 = getVolt(sockObject,12);
        Volt v120 = getVolt(sockObject,120);
        System.out.println("v3 volts using Object design pattern="+v3.getVolts());
        System.out.println("v12 volts using Object design pattern="+v12.getVolts());
        System.out.println("v120 volts using f design pattern="+v120.getVolts());
    }

    private static void testClassMethod() {
        SocketInterface sockObject = new SocketInterfaceImpl();
        Volt v3 = getVolt(sockObject,3);
        Volt v12 = getVolt(sockObject,12);
        Volt v120 = getVolt(sockObject,120);
        System.out.println("v3 volts using Class design pattern="+v3.getVolts());
        System.out.println("v12 volts using Class design pattern="+v12.getVolts());
        System.out.println("v120 volts using Class design pattern="+v120.getVolts());
    }

    private static Volt getVolt(SocketInterface sockObject, int i) {
        switch (i){
            case 3: return sockObject.get3Volt();
            case 12: return sockObject.get12Volt();
            case 120: return sockObject.get120Volt();
            default: return sockObject.get120Volt();
        }
    }
}