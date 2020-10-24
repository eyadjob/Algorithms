package oldstudy.tries;

import oldstudy.treesbook.BinaryTree;
import oldstudy.treesbook.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class isBinaryTreeTry {



    public static boolean is_bst(BinaryTreeNode root) {



       return  is_bst_rec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static Boolean is_bst_rec(BinaryTreeNode root, int  min, int max) {

        if (root == null)
            return null;

        if (root.data < min ||
                root.data > max) {
            return false;
        }


        return is_bst_rec(root.left, min, root.data) && is_bst_rec(root.right, root.data, max);
    }

    public static void main(String[] argv) {

        List<Integer> input = new ArrayList<Integer>();
        input.add(100);
        input.add(50);
        input.add(200);
        input.add(25);
        input.add(12);
        input.add(35);
        input.add(75);
        input.add(60);
        input.add(125);
        input.add(350);

        BinaryTreeNode root = BinaryTree.create_BST(input);
        BinaryTree.display_level_order(root);
        System.out.println();
        System.out.println("Is it BST?: " + is_bst(root));

        BinaryTreeNode root2 = BinaryTree.create_BST(input);
        System.out.println();
        BinaryTree.display_level_order(root2);
        System.out.println("Is it BST?: " + is_bst(root2));
    }

}
