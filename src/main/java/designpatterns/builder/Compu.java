package designpatterns.builder;

public class Compu {

    private String hd;
    private String cpu;
    private boolean hasBlu;
    private boolean hasWifi;

    public Compu(CompuBuilder compuBuilder) {

            this.hd = compuBuilder.hd;
            this.cpu = compuBuilder.cpu;

    }

    public String getHd() { return this.hd; }
    public String getCpu() { return this.cpu; }
    public boolean isHasWifi() {
        return hasWifi;
    }
    public boolean hasWifi() {
        return hasWifi;
    }

    public class CompuBuilder{

        private String hd;
        private String cpu;
        private boolean hasBlu;
        private boolean hasWifi;

        public CompuBuilder(String hd, String cpu) {
        this.hd = hd;
        this.cpu = cpu;

        }

        public CompuBuilder sethasBlu(boolean hasBlu) { this.hasBlu = hasBlu;
        return this;}

        public CompuBuilder setHasWifi(boolean hasWifi) { this.hasWifi = hasWifi;
            return this;}

        public Compu build() { return new Compu(this);}
    }

}
