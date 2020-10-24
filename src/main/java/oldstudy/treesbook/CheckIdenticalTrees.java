package oldstudy.treesbook;

import java.util.ArrayList;
import java.util.List;

public class CheckIdenticalTrees {

    public static boolean are_identical(
            BinaryTreeNode root1,
            BinaryTreeNode root2) {

        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 != null && root2 != null) {
            return ((root1.data == root2.data) &&
                    are_identical(root1.left, root2.left) &&
                    are_identical(root1.right, root2.right));
        }

        return false;
    }



    public static void main(String[] argv) {

        List<Integer> input1 = new ArrayList<Integer>();
        input1.add(100);
        input1.add(50);
        input1.add(200);
        input1.add(25);
        input1.add(125);
        input1.add(250);
        BinaryTreeNode root = BinaryTree.create_BST(input1);

        List<Integer> input2 = new ArrayList<Integer>();
        input2.add(1);
        input2.add(2);
        input2.add(10);
        input2.add(50);
        input2.add(180);
        input2.add(199);
        BinaryTreeNode root2 = BinaryTree.create_BST(input2);

        BinaryTree.display_level_order(root);
        System.out.println();

        BinaryTree.display_level_order(root2);
        System.out.println();

//        System.out.println("same " + (are_identical(root, root)));
//        System.out.println("null " + (!are_identical(root, null)));
//        System.out.println("null,null " + (are_identical(null, null)));
        System.out.println("different " + (!are_identical(root, root2)));
    }
}
