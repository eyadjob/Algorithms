package oldstudy.toptal2;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {

    public static boolean check(int start,int end,int size,int A[]){
        Set<Integer> set = new HashSet<Integer>();
        for(int i = start ; i<= end ; i++)
            set.add(A[i]);
        return set.size()==size;
    }

    public static int solution(int A[]){
        Set<Integer> set = new HashSet<Integer>();
        int n = A.length;
        for(int i = 0 ; i < n ; i++){
            set.add(A[i]);
        }
        int setSize = set.size();
        int answer = n;
        for(int i = 0 ; i < n ; i++){
            int start = i,end = n-1 , best = -1 ,mid;
            while(start<=end){
                mid = start+end>>1;
                if(check(i,mid,setSize,A)){
                    best =mid;
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }
            if(best==-1)
                break;
            answer = Math.min(answer,best-i+1);
        }
        return answer;
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
