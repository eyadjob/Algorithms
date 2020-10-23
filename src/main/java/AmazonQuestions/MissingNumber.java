package AmazonQuestions;

public class MissingNumber {



    public static Integer missingNumber(int [] array) {
        int low = 0;
        int high = array.length -1;

        int mid;

        while(low<high) {
            mid = (low+high)/2;

            int midArr = array[mid];
            int lowArr = array[low];
            if(mid-low == midArr - lowArr) {
                if( mid+1< array.length && midArr +1 != array[mid+1])
                    return midArr +1;
                else
                    low = mid+1;
            } else {
                if(mid -1 > -1 && midArr -1 != array[mid-1])
                    return midArr -1;
                else
                    high = mid-1;
            }
        }

        return null;
    }



    public static void main(String[] args) {


        int[] su = {1,2,4,5,6,7,8,9,10,11,12,13,14,15};

        System.out.println(missingNumber(su));


    }




}
