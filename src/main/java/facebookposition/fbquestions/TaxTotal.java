package facebookposition.fbquestions;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TaxTotal {

    int category;
    float taxperc;

    public TaxTotal(int category, float taxperc) {
        this.category = category;
        this.taxperc = taxperc;
    }

    public static void main(String[] args) {

        List<TaxTotal> values = new ArrayList<>();
        values.add(new TaxTotal(5000, 0));
        values.add(new TaxTotal(10000, 0.1f));
        values.add(new TaxTotal(20000, 0.2f));
        values.add(new TaxTotal(10000, 0.3f));
        values.add(new TaxTotal(10001, .4f));

        System.out.println(calculateTaxes(20000, values));
        System.out.println(calculateTaxesRec(20000, values, 0, 0, 0));
    }

    public static float calculateTaxesRec(int income, List<TaxTotal> taxTotals, int remaining, float taxValue, int index) {
        if (income <= 0) return taxValue;
        remaining = taxTotals.get(index).getCategory() % income;
        if (remaining > 0) taxValue += (remaining) * taxTotals.get(index).getTaxperc();
        else taxValue += (income) * taxTotals.get(index).getTaxperc();
        income = income - taxTotals.get(index).getCategory();
        return calculateTaxesRec(income, taxTotals, remaining, taxValue, ++index);
    }

    public static float calculateTaxes(int income, List<TaxTotal> taxTotals) {
        int remaining = 0;
        float taxValue = 0;
        for (int i = 0; i < taxTotals.size(); i++) {
            remaining = taxTotals.get(i).getCategory() % income;
            if (remaining > 0) taxValue += (remaining) * taxTotals.get(i).getTaxperc();
            else {
                if (income > 0)
                    taxValue += (income) * taxTotals.get(i).getTaxperc();
                break;
            }
            income = income - taxTotals.get(i).getCategory();
        }
        return taxValue;
    }
}

//    Implement the function:
//
//        float calculateTaxes(income, brackets)
//
//        where "brackets" is a list of pairs, e.g.
//        [
//        [5000, 0],
//        [10000, 0.1],
//        [20000, 0.2],
//        [10000, 0.3],
//        [null, 0.4],
//        ]

// 20k in income
// Tax = 5000 * 0 + 10000 * 0.1 + 5000 * 0.2 = 0 + 1000 + 1000 = 2000
