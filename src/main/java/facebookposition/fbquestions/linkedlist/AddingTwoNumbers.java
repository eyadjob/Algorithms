package facebookposition.fbquestions.linkedlist;

public class AddingTwoNumbers {

    public static void main(String[] args) {

        System.out.println();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode total = new ListNode();
        if ( l1 == null && l2 == null) return total;
        int carry =0;
        while ( l1 != null || l2 != null ) {
            total.val = (( l1 != null ? l1.val : 0) + ( l2 != null ? l2.val : 0)) % 10 + carry;
            carry = l1.val + l2.val / 10;
            l1 = l1.next;
            l2 = l2.next;
            total.next = new ListNode();
            total = total.next;
        }
        return total;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}



