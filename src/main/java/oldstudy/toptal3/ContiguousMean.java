package oldstudy.toptal3;

public class ContiguousMean {


    public static void main(String[] args) {
        int[] a = {2,1,3};
        int s = 2;
        System.out.println( "int[] a = {2,1,3}; int s = 2;");
        System.out.println(solution(a,s));

        int[] a2 = {0,4,3,-1};
        int s2 = 2;
        System.out.println( "int[] a2 = {0,4,3,-1}; int s2 = 2;");
        System.out.println(solution(a2,s2));

        int[] a3 = {2,1,4};
        int s3 = 3;
        System.out.println( "int[] a = {2,1,4}; int s = 3;");
        System.out.println(solution(a3,s3));
    }

      public static int solution(int A[],int S){
        long sum = 0;
        long answer = 0;
        int n = A.length;
        for(int i = 0 ; i < n ; i++){
            sum = 0;
            for(int j = i ; j < n ; j++){
                sum+=A[j];
                if(sum%S==0){
                    if(sum/(j-i+1) == S)answer++;
                }
                if(answer>=1000000000)
                    break;
            }
            if(answer>=1000000000)
                break;
        }
        if(answer>=1000000000)
            answer=1000000000;
        return (int) answer;
    }

}

