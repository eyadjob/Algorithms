package AmazonQuestions;

import treesbook.BinaryTree;
import treesbook.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class DetermineSubTree {


    public static boolean enterTree(BinaryTreeNode root, BinaryTreeNode subRoot) {

        if ( subRoot == null ) {
         return   true;
        }

        if ( root == null) {
           return  false;
        }

        if (subRoot.data != root.data ) {


                 return enterTree(root.left, subRoot) ||   enterTree(root.right, subRoot);

        } else { return subCheck(root, subRoot);}


    }

    public static boolean subCheck(BinaryTreeNode root, BinaryTreeNode   subRoot) {

            boolean flag = false;
            if (subRoot.data == root.data) {
                if (subRoot.left != null) {
                    enterTree(root.left, subRoot.left);
                }
                if (subRoot.right != null) {
                    enterTree(root.right, subRoot.right);
                }

            } else {

                return false;
            }


        return true;
    }


    public static void main(String[] args) {

        List<Integer> input1 = new ArrayList<Integer>();
        input1.add(100);
        input1.add(50);
        input1.add(200);
        input1.add(25);
        input1.add(125);
        input1.add(250);
        BinaryTreeNode root = BinaryTree.create_BST(input1);


        List<Integer> input2 = new ArrayList<Integer>();
        input2.add(300);
        input2.add(125);
        input2.add(250);
        BinaryTreeNode root2 = BinaryTree.create_BST(input2);

        BinaryTree.display_level_order(root);
        System.out.println();

        BinaryTree.display_level_order(root2);
        System.out.println();

        boolean re = enterTree(root, root2);
        System.out.println(re);


    }

}
