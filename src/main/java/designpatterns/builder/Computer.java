package designpatterns.builder;


public class Computer {

    private String hd;
    private String ram;
    private  boolean isGraphicEnabled;
    private boolean isBluetoothEnabled;

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    public String getRam() {
        return ram;
    }

    public boolean isGraphicEnabled() {
        return isGraphicEnabled;
    }


    public boolean isBluetoothEnabled() {
        return isBluetoothEnabled;
    }

    private Computer(ComputerBuilder computerBuilder ){
        this.hd = computerBuilder.hd;
        this.ram = computerBuilder.ram;
        this.isBluetoothEnabled = computerBuilder.isBluetoothEnabled;
        this.isGraphicEnabled = computerBuilder.isGraphicEnabled;
    }

    public static class ComputerBuilder {
        private String hd;
        private String ram;


        //optional params
        private boolean isGraphicEnabled;
        private boolean isBluetoothEnabled;

        public ComputerBuilder(String hd, String ram)
        {
            this.hd = hd;
            this.ram = ram;

        }

        public ComputerBuilder setGraphicEnabled(boolean isEnabled) {
            this.isGraphicEnabled = isEnabled;
            return this;
        }

        public ComputerBuilder setBlutoothEnabled(boolean isBluetoothEnbled) {
            this.isBluetoothEnabled = isBluetoothEnbled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }

    }
}
