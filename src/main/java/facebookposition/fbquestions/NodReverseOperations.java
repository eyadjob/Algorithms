//package facebookposition.fbquestions;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class NodReverseOperations {
//
//    public static void main(String[] args) {
//
//        int[] arr = {1, 2, 8, 9, 12, 16};
//        Node root = populateNods(new Node(0), arr, 0);
//        printNodes(root);
////        System.out.println(reverse(root));
//    }
//
//    public static Node reverse(Node root) {
//        int counter = 0, start = 0, end = 0, reverseCounter = 0, flag = 0;
//        List<Integer> needToReverse = new ArrayList<>();
//        while (root != null) {
//
//            if (counter == 0) {
//
//                if (root.value % 2 == 0) {
//                    ++end;
//                    reverseCounter += 1;
//                    flag = 1;
//                    continue;
//                } else {
//                    continue;
//                }
//            } else {
//                if (root.value % 2 == 0) {
//                    flag = 1;
//                    reverseCounter++;
//                } else {
//                    if (root.value % 2 != 2) {
//                        root = reverseLinkedList(root, reverseCounter, end);
//                        flag = 0;
//                        reverseCounter = 0;
//                    }
//
//                }
//            }
//        }
//
//
//        return new Node(0);
//
//    }
//
//    public static Node reverseLinkedList(Node root, int count, int end) {
//        if ( root == null || count == 0) return root;
//
//        Node temp = root;
//
//
//
//
//
//    }
//
//    public static void printNodes(Node root) {
//        if (root == null) return;
//
//        System.out.print(root.value + ", ");
//        printNodes(root.next);
//    }
//
//    public static Node populateNods(Node root, int[] arr, int i) {
//        if (i == arr.length) return root;
//        root.value = arr[i];
//        Node node = new Node(0);
//        if (i < arr.length - 1) {
//            root.next = node;
//        }
//        populateNods(node, arr, ++i);
//        return root;
//    }
//
//
//    public static class Node {
//        int value;
//        final Node next;
//
//        public Node(int value) {
//            this.value = value;
//            next = null;
//
//        }
//
//    }
//}
