package facebookposition.fbquestions.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class ReorderList2 {


    public static void main(String[] args) {
        int[] a8 = {1, 2, 3, 4};

        ListNode l1 = fillNodes(a8);
        reorderList(l1);
        while (l1 != null) {
            System.out.println(l1.val);
            l1 = l1.next;
        }
    }

    public static void reorderList(ListNode head) {
        ListNode tail = head;
        ListNode root = head;
        List<ListNode> pointers = new ArrayList<>();
        while (tail != null) {
            pointers.add(tail);
            if ( tail.next == null)
                break;
            tail = tail.next;
        }

        for ( int i =0; i < pointers.size();i++) {
            ListNode te = new ListNode();
            te = pointers.get(i).next;
            pointers.get(i).next = pointers.get(pointers.size()-1-i);
            pointers.get(pointers.size()-1-i).next =te;
            if ( pointers.size()-2-i >= 0 ) pointers.get(pointers.size()-2-i).next = null;
            else break;
            System.out.println();
        }
        System.out.println("test");


        while (root != null) {
//            ListNode tempNext = root.next;
            tail.next = root.next;
            root.next = tail;
            root = root.next;
            System.out.println();
        }

    }

    public static ListNode fillNodes(int[] a) {
        ListNode node = new ListNode(a[0]);
        ListNode root = node;
        for (int i = 1; i < a.length; i++) {
            node.next = new ListNode(a[i]);
            node = node.next;
        }
        return root;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
