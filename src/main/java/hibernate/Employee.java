package hibernate;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Data
public class Employee {


    private int id;
    private String name;
    private int salary;

    @Override
    public int hashCode(){
        return 0;
    }

    @Override
    public boolean equals(Object o) {

        return ((Employee)o).getId() == this.getId() && ((Employee) o).getName().equals(this.name);

    }


    public static void main(String[] args) {
        Set<Employee> set = new HashSet<>();

        Employee person1 = new Employee(1,"yousef",2000);
        Employee person2 = new Employee(1,"yousef", 2000);
        Employee person3 = new Employee(1, "yousef",2000);

        set.add(person1);
        set.add(person2);
        set.add(person3);
        System.out.println(set.size());

    }
}
