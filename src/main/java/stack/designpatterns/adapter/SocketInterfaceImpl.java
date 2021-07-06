package stack.designpatterns.adapter;

public class SocketInterfaceImpl extends Socket implements SocketInterface {
    @Override
    public Volt get120Volt() {
        return getVolt();
    }

    @Override
    public Volt get12Volt() {
        Volt volt = getVolt();
        return convertVolt(volt, 10);
    }

    @Override
    public Volt get3Volt() {
        Volt volt = getVolt();
        return convertVolt(volt, 40);
    }

    public Volt convertVolt(Volt volt, int mod) {
                return new Volt(volt.getVolts() /mod);
    }

}


