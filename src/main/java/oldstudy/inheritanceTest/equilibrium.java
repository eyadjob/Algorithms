package oldstudy.inheritanceTest;

/** @author eyadMubarak@redlinks
 */
public class equilibrium {

    public static int equilibriumIndex(int[] arr) {

        int sum = 0;
        int ls = 0;

        //calculate the sum of all elements in the array
        for (int i : arr) {
            sum += i;
        }

        for (int i = 0; i < arr.length; i++) {

            //add each left element before the index to a left sum variable
            if (i != 0) {
                ls += arr[i - 1];
            }

            // check if the (total sum of array elements - current element) - ( left sum so far * 2 ) == 0
            if ((sum - arr[i]) - ls * 2 == 0)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {0,1,1,5, 2,3,-1,4,0,1};
        System.out.println(equilibriumIndex(arr));
    }

}
