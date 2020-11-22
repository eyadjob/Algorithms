package facebookposition.fbquestions.linkedlist;

public class ReverseOperations {

    public static void main(String[] args) {
        ReverseOperations reverseOperations = new ReverseOperations();

        int[] arr_2 = {2, 18, 24, 3, 5, 7, 9, 6, 12};
//        int[] expected2 = {24, 18, 2, 3, 5, 7, 9, 12, 6};
        reverseOperations.test(arr_2);

        System.out.println();

        int[] list = {1, 2, 8, 9, 12, 16};
        reverseOperations.test(list);


    }

    public Node reverse(Node head) {
        Node node = head, oddStartNode = null, evenEnd = null;
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
                    if ( evenEnd == evenStart) evenEnd = evenStart.next;
                    reverseNodes(oddStartNode,evenStart, evenEnd,evenEnd.next);
                    firstEvenNodeMarked = false;
                    node = node.next;
                }
            } else {
                if (oddEnd) {
                    reverseNodes(oddStartNode,evenStart, evenEnd,evenEnd.next);
                    if (oddStartNode == null ) head = evenEnd;
                    firstEvenNodeMarked = false;
                    oddEnd = false;
                    oddStartNode = node;
                } else {
                    oddStartNode = node;
                }
            }
            evenEnd = node;
            node = node.next;
        }
        return head;
    }

    public void reverseNodes(Node oddStart, Node evenStart, Node evenEnd, Node oddEnd) {
        Node node = evenStart;
        Node prev = null;
        while (node != null && node != oddEnd) {
            Node next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        if ( oddStart!= null) oddStart.next = evenEnd;
        evenStart.next = oddEnd;
    }

    public void test(int[] arr) {
        Node node = fillNodes(arr);
        node =reverse(node);
        printNodes(node);
    }

    public Node fillNodes(int[] arr) {
        Node head = new Node(0);
        Node node = head;
        for (int i =0; i < arr.length; i++) {
            node.data = arr[i];
            if ( i != arr.length-1) {
                node.next = new Node(0);
                node = node.next;
            }
        }
        node = null;
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
