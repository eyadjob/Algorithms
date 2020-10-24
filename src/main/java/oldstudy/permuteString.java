package oldstudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class permuteString{

     static int count =0;
    public static List<String> result = new ArrayList<String>();
        public static String test = "21321";
    static void swap_char(char[] input, int i, int j){
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;
        test.hashCode();

    }

    static void permute_string(  char[] input,
            int current_index) {

        if(current_index == input.length - 1) {
            String addInput = new String(input);
            result.add(addInput);
            count++;
            return;
        }

        for(int i = current_index; i <= input.length - 1; i++) {
            swap_char(input,current_index,i);
            permute_string(input, current_index + 1);
            swap_char(input,current_index,i);
        }
    }

    static List<String> solution(String input) {
        permute_string(input.toCharArray(), 0);
        return result;
    }

    public static void main(String[] args) {
        String input = "abcd";
        List<String> result = solution(input);
        System.out.println(Arrays.toString(result.toArray()));
        System.out.println(count);
    }
}