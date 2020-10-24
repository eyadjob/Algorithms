package oldstudy;

import java.util.ArrayList;


public class InorderSuccessorBST {


    static BinaryTree bt;

    static BinaryTree.BinaryTreeNode find_min(
            BinaryTree.BinaryTreeNode root) {

        if(root == null)
            return null;

        while(root.left != null) {
            root = root.left;
        }

        return root;
    }

    static BinaryTree.BinaryTreeNode inorder_successor_bst(
            BinaryTree.BinaryTreeNode root,
            int d) {

        if(root == null) {
            return null;
        }

        BinaryTree.BinaryTreeNode successor = null;

        while (root != null) {

            if(root.getValue() < d) {
                root = root.right;
            }
            else if(root.getValue() > d) {
                successor = root;
                root = root.left;
            }
            else {
                if(root.getRight() != null)
                {
                    successor = find_min(root.right);
                }
                break;
            }
        }
        return successor;
    }

    public static void main(String[] args) {
        ArrayList<Integer> orig_data = new ArrayList<Integer>();
        orig_data.add(25);
        orig_data.add(125);
        orig_data.add(200);
        orig_data.add(350);
        orig_data.add(50);
        orig_data.add(75);
        orig_data.add(100);
        BinaryTree.BinaryTreeNode root = BinaryTree.create_BST(orig_data);
        BinaryTree bt = new BinaryTree(root);

        ArrayList<Integer> all_data = new ArrayList<>();
//        binaryTree.head = root;
        while (bt.hasNext()) {
            all_data.add(bt.next().getValue());
        }

        for (Integer d : orig_data) {
            BinaryTree.BinaryTreeNode successor = inorder_successor_bst(root, d);
            int i = all_data.indexOf(d);
            Integer expected_val = null;
            if (i < all_data.size() - 1) {
                expected_val = all_data.get(i + 1);
            }

            if (successor != null) {
                if (expected_val.intValue() != successor.getValue()) {
                    System.out.println("**" + d + " ==== " + expected_val + ", " + successor.getValue() + "**");
                    //System.out.println(expected_val.intValue() == successor.data);
                }
            } else {
                //System.out.println(successor == null);
            }
            if (successor != null) {
                System.out.print("(" + d + ", " + successor.getValue() + ") ");
            } else {
                System.out.print("(" + d + ", null) ");
            }
        }
    }
}