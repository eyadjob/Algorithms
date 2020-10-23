package reverselinklistproblem;

import java.util.Random;

public class ReverseSingleLinkedListAmjad {

    public static void main(String[] args) {
        LinkedListNode list_head = null;
        list_head = LinkedList.create_random_list(10);

        System.out.print("Original: ");
        LinkedList.display(list_head);

        list_head = reverse_iterative(list_head);
        System.out.print("After Reverse (Iterative):");
        LinkedList.display(list_head);
    }

    private static LinkedListNode reverse_iterative(LinkedListNode list_head) {

        LinkedListNode list = list_head;
        LinkedListNode next = list_head.next;
        list.next =null;
        while (next != null) {

            LinkedListNode cursor = next.next;
            next.next = list;
            list = next;
            next = cursor;

        }

        return list;
    }

    static class LinkedListNode {
        Integer value;
        LinkedListNode next;

        @Override
        public String toString() {
            return "data : "+value+" -> "+(next ==null?" null ":next.value );
        }
    }


    static class LinkedList {


        public static void display(LinkedListNode list_head) {

            while (list_head != null) {
                System.out.print(list_head.value+" , ");
                list_head = list_head.next;
            }
            System.out.println();
        }

        public static LinkedListNode create_random_list(int max) {
            Random random = new Random();
            LinkedListNode head = new LinkedListNode();
            head.value = random.nextInt(100);
            LinkedListNode pre = head;
            for (int i = 1; i < max; i++) {
                LinkedListNode current = new LinkedListNode();
                current.value = random.nextInt(100);
                pre.next = current;
                pre = current;
            }
            return head;
        }
    }

}