import treesbook.BinaryTree;
import treesbook.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class NthighestBST {

    static int counter = 0;
    static int value = -1;

    public static int getValueOfNightHighest(BinaryTreeNode root, int nth) {

        if (root == null)
            return -1;

        if (root.right != null) {
            getValueOfNightHighest(root.right, nth);
        }

        ++counter;
        if (counter == nth) {
            value = root.data;
            return root.data;
        }

        if (root.left != null) {
            getValueOfNightHighest(root.left, nth);
        }

        return value;

    }


    public static void main(String[] args) {

        List<Integer> input1 = new ArrayList<Integer>();
        input1.add(100);
        input1.add(50);
        input1.add(200);
        input1.add(25);
        input1.add(75);
        input1.add(125);
        input1.add(350);
        BinaryTreeNode root = BinaryTree.create_BST(input1);
//        BinaryTree.display_level_order(root);
        System.out.println(getValueOfNightHighest(root, 2));


    }


}
