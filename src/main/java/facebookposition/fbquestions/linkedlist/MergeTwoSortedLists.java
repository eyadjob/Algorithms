package facebookposition.fbquestions.linkedlist;


public class MergeTwoSortedLists {

    static ListNode root = new ListNode();

    public static void main(String[] args) {


        int[] a8  = {-4,-2,0,1,4};
        int[] b8=   {-9,-8,-6,-6,-5,-1,1,4,9};
        ListNode l18 = fillNodes(a8);
        ListNode l28 = fillNodes(b8);
        ListNode re8 = mergeTwoLists(l18, l28);
        while (re8 != null) {
            System.out.println(re8.val);
            re8 = re8.next;
        }

        System.out.println();

        int[] a7  = {-2,5};
        int[] b7=   {-9,-6,-3,-1,1,6};
        ListNode l17 = fillNodes(a7);
        ListNode l27 = fillNodes(b7);
        ListNode re7 = mergeTwoLists(l17, l27);
        while (re7 != null) {
            System.out.println(re7.val);
            re7 = re7.next;
        }

        System.out.println();

        int[] a6  = {-10,-6,-6,-6,-3,5};
        int[] b6=   {1};
        ListNode l16 = fillNodes(a6);
        ListNode l26 = null;
        ListNode re6 = mergeTwoLists(l16, l26);
        while (re6 != null) {
            System.out.println(re6.val);
            re6 = re6.next;
        }

        System.out.println();

        int[] a4 = {1};
        int[] b4 = {1};
        ListNode l14 = fillNodes(b4);
        ListNode l24 = null;
        ListNode re4 = mergeTwoLists(l14, l24);
        while (re4 != null) {
            System.out.println(re4.val);
            re4 = re4.next;
        }

        System.out.println();

        int[] a = {};
        int[] b = {0};
        ListNode l1 = null;
        ListNode l2 = fillNodes(b);
        ListNode re = mergeTwoLists(l1, l2);
        while (re != null) {
            System.out.println(re.val);
            re = re.next;
        }

        System.out.println();

        int[] a5 = {1,2,4};
        int[] b5 = {1,3,4};
        ListNode l15 = fillNodes(a5);
        ListNode l25 = fillNodes(b5);
        ListNode re5 = mergeTwoLists(l15, l25);
        while (re5 != null) {
            System.out.println(re5.val);
            re5 = re5.next;
        }

        System.out.println();


        int[] a3 = {5};
        int[] b3 = {1, 2, 4};
        ListNode l13 = fillNodes(a3);
        ListNode l23 = fillNodes(b3);
        ListNode re3 = mergeTwoLists(l13, l23);
        while (re3 != null) {
            System.out.println(re3.val);
            re3 = re3.next;
        }

        System.out.println();

        int[] a2 = {-9, 3};
        int[] b2 = {5, 7};
        ListNode l12 = fillNodes(a2);
        ListNode l22 = fillNodes(b2);
        ListNode re2 = mergeTwoLists(l12, l22);
        while (re2 != null) {
            System.out.println(re2.val);
            re2 = re2.next;
        }


    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        else if(l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(l1 != null && l2!= null){
            if(l1.val <= l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null? l2:l1;
        return dummy.next;
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


    public static ListNode  mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }


    public static ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        root = null;
        if (l1 == null && l2 == null) return null;
        ListNode node = null;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                if (l2 != null) {
                    if (l1.val < l2.val) {
                        node = compareAndReplaceIfLarger(node, l2.val, l1.val);
                    } else if (l1.val > l2.val) {
                        node = compareAndReplaceIfLarger(node, l1.val, l2.val);
                    } else {
                        node = compareAndReplaceIfLarger(node, l1.val, l2.val);
                    }
                } else {
                    node = compareAndReplaceIfLarger(node, l1.val);
                }
            } else {
                node = compareAndReplaceIfLarger(node, l2.val);
            }
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        ListNode temp = root;
        sortListRecursively( temp);
        return root;
    }

    public static void sortListRecursively(ListNode  root) {
        if ( root == null || root.next == null) return;
        if ( root.val > root.next.val ) {
            int temp = root.val;
            root.val = root.next.val;
            root.next.val = temp;

        }
        root = root.next;
        sortListRecursively(root);
    }


    public static ListNode compareAndReplaceIfLarger(ListNode node, int v1) {
        if (node == null) {
            node = new ListNode(v1);
            root = node;
        } else {
            if (node.val > v1) {
                int temp = node.val;
                node.val = v1;
                node.next = new ListNode(temp);
                node = node.next;
            } else {
                node.next = new ListNode(v1);
                node = node.next;
            }
        }
        return node;
    }

    public static ListNode compareAndReplaceIfLarger(ListNode node, int large, int small) {
        if (node == null) {
            node = new ListNode(small);
            root = node;
            node.next = new ListNode(large);
            node = node.next;
        } else {
            if (node.val > large) {
                int temp = node.val;
                node.val = small;
                node.next = new ListNode(temp);
                int temp2 = node.val;
                node.val = large;
                node.next = new ListNode(temp2);
                node = node.next;
            } else {
                if (node.val > small) {
                    int temp = node.val;
                    node.val = small;
                    node.next = new ListNode(temp);
                    node = node.next;
                    node.next = new ListNode(large);
                    node = node.next;
                } else {
                    node.next = new ListNode(small);
                    node = node.next;
                    node.next = new ListNode(large);
                    node = node.next;
                }
            }
        }
        return node;
    }

    public static ListNode replaceNodesValues(ListNode node, int value) {
        int temp = node.val;
        node.val = value;
        node.next = new ListNode(temp);
        return node;
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
