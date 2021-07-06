package stack.designpatterns.prototype;


import java.util.List;

public class Test {


    public static void main(String[] args) throws CloneNotSupportedException {
        Employees emps  = new Employees();
        emps.loadData();


        Employees empNew = (Employees) emps.clone();
        Employees empNew1 = (Employees) emps.clone();

        List<String> list = empNew.getEmplist();
        list.add("John");
        List<String> list1 = empNew1.getEmplist();
        list1.remove("Pankaj");

        System.out.println("emps list : " + emps.getEmplist());
        System.out.println("empnew : " + empNew.getEmplist());
        System.out.println("empNew1" + list1);

    }
}
