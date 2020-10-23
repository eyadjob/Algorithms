package designpatterns.adapter;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Volt {

    public int getVolts() {
        return volts;
    }

    public void setVolts(int volts) {
        this.volts = volts;
    }

    private int volts;


    public Volt(int v ) {
        this.volts = v;
    }




}
