package oldstudy.treesbook;

import java.util.ArrayList;

public class DeleteZeroSumSubTree {

    public static int delete_zero_sum_subtree_rec(
            BinaryTreeNode root) {

        if (root == null) {
            return 0;
        }

        int sum_left =
                delete_zero_sum_subtree_rec(root.left);
        int sum_right =
                delete_zero_sum_subtree_rec(root.right);

        if (sum_left == 0) {
            root.left = null;
        }
        if (sum_right == 0) {
            root.right = null;
        }

        return root.data + sum_left + sum_right;
    }

    public static void delete_zero_sum_subtree(
            BinaryTree tree) {

        if (tree == null || tree.getRoot() == null) {
            return;
        }

        if (0 == delete_zero_sum_subtree_rec(tree.getRoot())) {
            tree.root = null;
        }
    }


    public static void main(String[] argv) {
        ArrayList<Integer> orig_data = new ArrayList<Integer>();
        orig_data.add(7);
        orig_data.add(5);
        orig_data.add(8);
        orig_data.add(-3);
        orig_data.add(-2);

       BinaryTree binaryTree = new BinaryTree(BinaryTree.create_BST(orig_data));

        BinaryTree.display_level_order(binaryTree.getRoot());
        System.out.println();
        delete_zero_sum_subtree(binaryTree);
        BinaryTree.display_level_order(binaryTree.getRoot());
    }


}
