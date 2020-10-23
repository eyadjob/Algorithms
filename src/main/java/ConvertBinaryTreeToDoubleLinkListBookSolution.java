import java.util.ArrayList;
import java.util.List;

public class ConvertBinaryTreeToDoubleLinkListBookSolution {


    static BinaryTree.BinaryTreeNode concatenate_lists(
            BinaryTree.BinaryTreeNode head1,
            BinaryTree.BinaryTreeNode head2) {

        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        // use left for previous.
        // use right for next.
        BinaryTree.BinaryTreeNode tail1 = head1.left;
        BinaryTree.BinaryTreeNode tail2 = head2.left;

        tail1.right = head2;
        head2.left = tail1;

        head1.left = tail2;
        tail2.right = head1;
        return head1;
    }


    public static BinaryTree.BinaryTreeNode convert_to_linked_list(
            BinaryTree.BinaryTreeNode root) {

        if (root == null) {
            return null;
        }

        BinaryTree.BinaryTreeNode list1 = convert_to_linked_list(root.getLeft());
        BinaryTree.BinaryTreeNode list2 = convert_to_linked_list(root.right);

        root.left = root.right = root;
        BinaryTree.BinaryTreeNode result = concatenate_lists(list1, root);
        result = concatenate_lists(result, list2);

        return result;
    }

    static List<Integer> get_list(BinaryTree.BinaryTreeNode head) {
        List<Integer> r = new ArrayList<Integer>();
        if (head == null) {
            return r;
        }

        BinaryTree.BinaryTreeNode temp = head;
        do {
            r.add(temp.getValue());
            temp = temp.right;
        }while (temp != head);

        return r;
    }

    public static void main(String[] args) {

        List<Integer> input = new ArrayList<Integer>();
        input.add(100);input.add(50);input.add(200);input.add(25);input.add(75);input.add(125);input.add(350);
        input.add(30);input.add(60);
        BinaryTree.BinaryTreeNode root = BinaryTree.create_BST(input);

        BinaryTree.BinaryTreeNode head = convert_to_linked_list(root);
        List<Integer> result = get_list(head);
        System.out.println(result);
    }
}



//    Convert Binary Tree to Doubly Linked List
//        Given a binary tree, convert it to a doubly linked list so that the order of the doubly linked list is the same as an in-order traversal of the binary tree.
//
//        We'll cover the following...
//        Description
//        Convert a binary tree to a doubly linked list so that the order of the doubly linked list is the same as an in-order traversal of the binary tree. After conversion, the left pointer of the node should be pointing to the previous node in the doubly linked list, and the right pointer should be pointing to the next node in the doubly linked list.
//
//        Consider the tree below:
//
//        100
//        50
//        200
//        25
//        75
//        30
//        60
//        125
//        350
//        Its in-order traversal will be 25, 30, 50, 60, 75, 100, 125, 200, 350. So, the output doubly linked list should look like so:
//
//        25
//        30
//        50
//        60
//        75
//        100
//        125
//        200
//        350
//        Hints
//        Divide and conquer
//        Recursion
//        Fuse already processed sub-trees