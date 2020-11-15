package facebookposition.fbquestions.linkedlist;

public class ReverseOperations {

    public static void main(String[] args) {
        int[] list = {1, 2, 8, 9, 12, 16};
        ReverseOperations reverseOperations = new ReverseOperations();
        reverseOperations.test(list);

    }

    public Node reverse(Node head) {
        Node node = head, prev = null;
        Node evenStart = null;
        boolean firstEvenNodeMarked = false, oddEnd = false;
        while (node != null) {
            if (node.data % 2 == 0) {
                oddEnd = true;
                if (!firstEvenNodeMarked) {
                    evenStart = node;
                    firstEvenNodeMarked = true;
                }
                if (node.next == null) {
                    reverseNodes(evenStart, prev);
                    firstEvenNodeMarked = false;
                }
            } else {
                if (oddEnd) {
                    reverseNodes(evenStart, prev);
                    firstEvenNodeMarked = false;
                    oddEnd = false;
                }
            }
            prev = node;
            node = node.next;
        }
        return head;
    }

    public void reverseNodes(Node head, Node end) {
        Node node = head;
        while (node != null && node != end) {
            Node temp = node.next;
            temp.next = node;
            node = node.next;
        }
      
    }

    public void test(int[] arr) {
        Node node = fillNodes(arr);
        reverse(node);
        printNodes(node);
    }

    public Node fillNodes(int[] arr) {
        Node head = new Node(0);
        Node node = head;
        for (int v : arr) {
            node.data = v;
            node.next = new Node(0);
            node = node.next;
        }
        node.next = null;
        return head;
    }

    public void printNodes(Node head) {
        Node node = head;
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
            next = null;
        }


    }
}
