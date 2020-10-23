//import linkedList.BinaryTreeNode;
//
//public class Reverse {
//
//
//    public static LinkedListNode reverse_list(LinkedListNode head) {
//
//
//        LinkedListNode reversed_list = head;
//        LinkedListNode lastNod= new LinkedListNode();
//        while ( reversed_list != null) {
//            lastNod = reversed_list.next;
//            reversed_list = reversed_list.next;
//        }
//        LinkedListNode headn= head;
//        LinkedListNode tempNod= new LinkedListNode();
//        while (headn != null ) {
//            tempNod =lastNod;
//            lastNod = headn;
//            headn =  tempNod;
//            headn = new LinkedListNode();
//            headn= lastNod.next;
//
//
//        }
//
//
//        //TODO: Write - Your - Code
//        return reversed_list;
//    }
//
//    public static void main(String[] args) {
//        LinkedListNode list_head = null;
//        list_head = LinkedList.create_random_list(10);
//
//        System.out.print("Original: ");
//        LinkedList.display(list_head);
//
//        list_head = reverse_iterative(list_head);
//        System.out.print("After Reverse (Iterative):");
//        LinkedList.display(list_head);
//    }
//
//    public static class LinkedListNode {
//        int item;
//        LinkedListNode next;
//        static LinkedListNode first;
//        static int N;
//
//
//
//    }
//
//    public static class LinkedList {
//            public static LinkedListNode create_random_list(int n) {
//            LinkedListNode headNod = new LinkedListNode();
//
//
//            for (int i = 0; i < n; i++) {
//                if (i == 0) {
//                    headNod = LinkedListNode.first;
//                }
//                LinkedListNode oldFirst = LinkedListNode.first;
//                LinkedListNode.first = new LinkedListNode();
//                LinkedListNode.first.item = i;
//                LinkedListNode.first.next = oldFirst;
//                ++LinkedListNode.N;
//
//            }
//            return headNod;
//        }
//
//    }
//}