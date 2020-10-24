package oldstudy.inheritanceTest;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

    int id;
    int age;
    String name;


    public SetTest(int id, int age, String name) {
        this.age = age;
        this.name = name;
        this.id = id;
    }

//    @Override
//    public int hashCode() {
//            return 0;
//    }
//
//
//    @Override
//    public boolean equals(Object o){
//        return ((SetTest) o).age == this.age && ((SetTest) o).name == name;
//    }


    public static void main(String[] args) {

        SetTest t1 = new SetTest(1, 22,"am" );
        SetTest t2 = new SetTest(1, 22,"am" );
        String amjad = "eyad";
        Set<SetTest> test = new HashSet<>();

        test.add(t1);
        test.add(t2);


        System.out.println(test.size());


    }

}
