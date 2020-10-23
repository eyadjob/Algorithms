package hackerrank.easy;

import treesbook.BinaryTree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BillBetweenBillAndAnna {

    // Complete the bonAppetit function below.
    static void bonAppetit(List<Integer> bill, int k, int b) {

        int annaB = 0;
        int brian = 0;
        for ( int i =0; i < bill.size(); i++) {
            if (i != k) {

                annaB += bill.get(i);
            }
            brian += bill.get(i);



        }

        annaB = annaB /2;
        brian = brian /2;

        if ( b - annaB == 0 )
            System.out.println("Bon Appetit");
        else       System.out.println(b - annaB);


    }

    public static void main(String[] args) throws IOException {
        List<Integer> bill = new ArrayList<>();
        bill.add(3);
        bill.add(10);
        bill.add(2);
        bill.add(9);

        bonAppetit(bill, 1,12);


    }


}
