package thread.multiplelocks;

import lombok.Data;

@Data
public class BankAccount {


    private double amount =10000;


    public BankAccount(double amount ) {
        this.amount = amount;
    }

    public BankAccount( ) {

    }

    public void addAmount(double amount) {
        this.amount += amount;
    }


    public void withDraw(double amount) {
        this.amount -= amount;
    }


    public static  void transferAmount(BankAccount first, BankAccount second, double amount) {
        first.withDraw(amount);
        second.addAmount(amount);

    }
}
