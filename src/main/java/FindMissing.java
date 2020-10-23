import java.util.*;

public class FindMissing {

        static int find_missing(List<Integer> input) {
            //TODO: Write - Your - Code

            Map<Integer, Integer> sorted = new TreeMap<>();
            int previouslast = 0;
            Collections.sort(input);


            for (int i = 0; i < input.size()-1; i++) {

                if ((input.get(i + 1)  - input.get(i) ) > 1) {
                    return input.get(i) + 1;
                }

            }
            return -1;
        }
            static void test ( int n){
                int missing_element = (new Random()).nextInt(n) + 1;
                List<Integer> v = new ArrayList<Integer>();
                for (int i = 1; i <= n; ++i) {
                    if (i != missing_element)
                        v.add(i);
                }

                int actual_missing = find_missing(v);
                System.out.print("Expected Missing = ");
                System.out.print(missing_element);
                System.out.print(" Actual Missing = ");
                System.out.println(actual_missing);
                System.out.println("Missing Element == Actual Missing : " + (missing_element == actual_missing));
            }


    public static void main(String[] args) {
        for (int n = 0; n < 10; ++n)
            test(100000);
    }


}
