package oldstudy.codility;

import java.util.Stack;

public class Fish {


    public static void main(String[] args) {
        int[] A = {4, 3, 2, 1, 5};
        int[] B = {0, 1, 0, 0, 0};
        System.out.println(solution(A, B));
    }

    public static int solution(int[] A, int[] B) {
        int n = A.length;
        Stack<FishBean> ss = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                ss.push(new FishBean(A[i], B[i]));
                continue;
            }
            if (ss.peek().dir == 1 && B[i] == 0) {
                if (ss.peek().size < A[i]) {
                    while (!ss.empty()) {
                        if (ss.peek().size < A[i] && ss.peek().dir == 1) {
                            ss.pop();
                        } else {
                            break;
                        }
                    }
                    if (ss.empty() || ss.peek().dir == 0) ss.push(new FishBean(A[i], B[i]));
                }
            } else ss.push(new FishBean(A[i], B[i]));
        }
        return ss.size();
    }

    //    100% solution
    public int solution2(int[] A, int[] B) {
        //Stack<Integer> fishDirections = new Stack<>();
        Stack<Integer> fishSizes = new Stack<>();
        int eatenNumber = 0;
        for (int i = 0; i < A.length; i++) {
            if (!fishSizes.isEmpty() && B[i] == 0) {
                if (fishSizes.peek() > A[i]) {
                    eatenNumber++;
                } else {
                    while (!fishSizes.isEmpty() && fishSizes.peek() < A[i]) {
                        fishSizes.pop();
                        eatenNumber++;
                    }
                    if (!fishSizes.isEmpty()) {
                        eatenNumber++;
                    }
                }
            } else if (B[i] == 1) {
                fishSizes.push(A[i]);

            }
        }
        return (A.length - eatenNumber);
    }

    public static class FishBean {
        int size = 0;
        int dir = 0;

        public FishBean(int size, int dir) {
            this.size = size;
            this.dir = dir;
        }

    }

}


//    You are given two non-empty arrays A and B consisting of N integers. Arrays A and B represent N voracious fish in a river, ordered downstream along the flow of the river.
//
//        The fish are numbered from 0 to N − 1. If P and Q are two fish and P < Q, then fish P is initially upstream of fish Q. Initially, each fish has a unique position.
//
//        Fish number P is represented by A[P] and B[P]. Array A contains the sizes of the fish. All its elements are unique. Array B contains the directions of the fish. It contains only 0s and/or 1s, where:
//
//        0 represents a fish flowing upstream,
//        1 represents a fish flowing downstream.
//        If two fish move in opposite directions and there are no other (living) fish between them, they will eventually meet each other. Then only one fish can stay alive − the larger fish eats the smaller one. More precisely, we say that two fish P and Q meet each other when P < Q, B[P] = 1 and B[Q] = 0, and there are no living fish between them. After they meet:
//
//        If A[P] > A[Q] then P eats Q, and P will still be flowing downstream,
//        If A[Q] > A[P] then Q eats P, and Q will still be flowing upstream.
//        We assume that all the fish are flowing at the same speed. That is, fish moving in the same direction never meet. The goal is to calculate the number of fish that will stay alive.
//
//        For example, consider arrays A and B such that:
