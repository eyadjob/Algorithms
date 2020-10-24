package oldstudy.designpatterns.builder;

public class Test {

    public static void main(String[] args) {

        Computer computer  = new Computer.ComputerBuilder("1TB","32G").setGraphicEnabled(false).build();

        System.out.println(computer.getHd());
        System.out.println(computer.getRam());
        System.out.println(computer.isBluetoothEnabled());
        System.out.println(computer.isGraphicEnabled());

    }
}
