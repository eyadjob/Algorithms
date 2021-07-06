package stack.designpatterns.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable {

    private int x =0;

    private List<String> emplist;

    public Employees() {
        emplist = new ArrayList<>();
    }

    public Employees(List<String> list) {
        this.emplist = list;
    }

    public void loadData() {
        emplist.add("eyad");
        emplist.add("yosuef");
        emplist.add("ayat");
        emplist.add("Pankaj");
    }

    public List<String> getEmplist() {
        return emplist;
    }


    @Override
    public Object clone() throws CloneNotSupportedException {

        List<String> temp = new ArrayList<>(emplist);
        return new Employees(temp);
    }

    public void sum() {

             int x =0;
    }
}
