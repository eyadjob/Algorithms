package stack;

import java.util.*;

public class ArrayStackDemo<T> {

    public static void main(String[] args) {

        ArrayStack<String> s1 = new ArrayStack<>();
        s1.push("eyad");
        s1.push("odai");
        s1.push("laith");
        ArrayStack<String> s2 = new ArrayStack<>();
        s2.push("odai");

//        System.out.println(countStackDistinct(s1, s2));
        System.out.println(countStackDistinct2(s1, s2));
        ArrayStack<Integer> s3 = new ArrayStack<>();
        s3.push(1);
        s3.push(5);
        s3.push(6);
        s3.push(6);
        s3.push(1);
        s3.push(5);
        s3.push(6);
        s3.push(6); s3.push(1);
        s3.push(5);
        s3.push(6);
        s3.push(6);
        s3.push(1);
        s3.push(5);
        s3.push(6);
        s3.push(6);
        s3.push(1);
        s3.push(5);
        s3.push(6);
        s3.push(6);
        s3.push(1);
        s3.push(5);
        s3.push(6);
        s3.push(6);
        s3.push(1);
        s3.push(5);
        s3.push(6);
        s3.push(6);
        s3.push(1);
        s3.push(5);
        s3.push(6);
        s3.push(6);
        s3.push(1);
        s3.push(5);
        s3.push(6);
        s3.push(6);
        s3.push(1);
        s3.push(5);
        s3.push(6);
        s3.push(6);
        s3.push(1);
        s3.push(5);
        s3.push(6);
        s3.push(6);
        s3.push(1);
        s3.push(5);
        s3.push(6);
        s3.push(6);




        ArrayStack<Integer> s4 = new ArrayStack<>();
        s4.push(1);
        s4.push(5);
        s4.push(7);
        s4.push(7);
        s4.push(1);
        s4.push(5);
        s4.push(7);
        s4.push(7);
        s4.push(1);
        s4.push(5);
        s4.push(7);
        s4.push(7);
        s4.push(1);
        s4.push(5);
        s4.push(7);
        s4.push(7);
        s4.push(1);
        s4.push(5);
        s4.push(7);
        s4.push(7);
        s4.push(1);
        s4.push(5);
        s4.push(7);
        s4.push(7);
        s4.push(1);
        s4.push(5);
        s4.push(7);
        s4.push(7);
        s4.push(1);
        s4.push(5);
        s4.push(7);
        s4.push(7);
        s4.push(1);
        s4.push(5);
        s4.push(7);
        s4.push(7);
        s4.push(1);
        s4.push(5);
        s4.push(7);
        s4.push(7);
        s4.push(1);
        s4.push(5);
        s4.push(7);
        s4.push(7);
        s4.push(1);
        s4.push(5);
        s4.push(7);
        s4.push(7);
//        System.out.println(countStackDistinct(s3, s4));
        long start = System.nanoTime();
        System.out.println(countStackDistinct3(s3, s4));
        System.out.println((System.nanoTime() - start ) /1000);

        ArrayStack<Integer> s5 = new ArrayStack<>();
        s5.push(1);
        s5.push(5);
        s5.push(6);
        s5.push(1);
        s5.push(1);
        s5.push(5);
        s5.push(6);
        s5.push(1);
        s5.push(1);
        s5.push(5);
        s5.push(6);
        s5.push(1);
        s5.push(1);
        s5.push(5);
        s5.push(6);
        s5.push(1);
        s5.push(1);
        s5.push(5);
        s5.push(6);
        s5.push(1);
        s5.push(1);
        s5.push(5);
        s5.push(6);
        s5.push(1);
        s5.push(1);
        s5.push(5);
        s5.push(6);
        s5.push(1);
        s5.push(1);
        s5.push(5);
        s5.push(6);
        s5.push(1);
        s5.push(1);
        s5.push(5);
        s5.push(6);
        s5.push(1);

        System.out.println(removeTopNthStackElement(s5, 1));


        System.out.println(removeTopNthStackElement(s5, 1));


    }


    public static <T> int countStackDistinct2(ArrayStack<T> s1, ArrayStack<T> s2) {

        int count = 0;
        ArrayStack<T> tempStackS1 = new ArrayStack<T>();
        while (!s1.isEmpty()) {
            T stTmp1 = s1.top();
            boolean isFound = false;

            ArrayStack<T> tempStack2 = new ArrayStack<T>();
            while (!s2.isEmpty()) {
                T stTmp2 = s2.top();
                if(stTmp1 == stTmp2){
                    isFound = true;
                }
                s2.pop();
                tempStack2.push(stTmp2);

            }

            if(s2.isEmpty()){
                while (!tempStack2.isEmpty()) {
                    s2.push(tempStack2.top());
                    tempStack2.pop();
                }
            }
            if(!isFound){
                count++;
            }

            tempStackS1.push(stTmp1);
            s1.pop();

        }

        if(s1.isEmpty()){
            while (!tempStackS1.isEmpty()) {
                s1.push(tempStackS1.top());
                tempStackS1.pop();
            }
        }
        return count;
    }

    public static <T> int countStackDistinct3(ArrayStack<T> s1, ArrayStack<T> s2) {
        Set<T> result = new HashSet<>();
        while (!s1.isEmpty()) {
            T element = s1.top();
            result.add(element);
            s1.pop();
        }
        while (!s2.isEmpty()) {
            T element2 = s2.top();
            result.add(element2);
            s2.pop();
        }
        return result.size();
    }

    public static <T> int countStackDistinct(ArrayStack<T> s1, ArrayStack<T> s2) {
        Map<T, Integer> result = new HashMap<>();
        while (!s1.isEmpty()) {
            T element = s1.top();
            result.put(element, result.getOrDefault(element, 0) + 1);
            s1.pop();
        }
        while (!s2.isEmpty()) {
            T element2 = s2.top();
            result.put(element2, result.getOrDefault(element2, 0) + 1);
            s2.pop();
        }
        int count = 0;
        for (Map.Entry<T, Integer> v : result.entrySet()) {
            if (v.getValue() == 1) count++;
        }
        return count;
    }

    public static <T> boolean removeTopNthStackElement(ArrayStack<T> st, T element) {
        List<T> tempArr = new ArrayList<T>();
        int i = 0;
        boolean flag=false;
        while (!st.isEmpty() ) {
            T stackElement = st.top();
            if (stackElement != element || flag) {
                tempArr.add(stackElement);
            } else {
                flag =true;
            }
           st.pop();
        }
        ArrayStack<T> temp = new ArrayStack<>();
        for ( int k =tempArr.size()-1; k >=0;k-- ) {
            temp.push(tempArr.get(k));
        }
        st.stack = temp.stack;
        return flag;
    }

}
