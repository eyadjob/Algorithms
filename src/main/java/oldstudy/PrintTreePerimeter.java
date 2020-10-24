package oldstudy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrintTreePerimeter {


    private static void display_tree_perimeter(BinaryTree.BinaryTreeNode root) {

        if(root == null){
            return;
        }
        printLeft(root.left);
        printLeaf(root.left);
        printLeaf(root.right);
        printRight(root.right);

    }


    private static void printLeft(BinaryTree.BinaryTreeNode root) {

        while (root != null) {
            int v = root.getValue();
            if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {

                root = root.right;
            } else {
                break;
            }

            System.out.println(v);


        }

    }


    private static void printRight(BinaryTree.BinaryTreeNode root) {
        Stack<Integer> stack = new Stack<>();

        while (root != null) {
            int v = root.getValue();
            if (root.right != null) {
                root = root.right;
            } else if (root.left != null) {

                root = root.left;
            } else {
                break;
            }

            stack.push(v);

        }
        while (!stack.empty()){
            System.out.println(stack.pop());
        }

    }

    static void printLeaf(BinaryTree.BinaryTreeNode root){

        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            System.out.println(root.getValue());
        }
        if(root.left != null){
            printLeaf(root.left);
        }
        if(root.right != null){
            printLeaf(root.right);
        }

    }

    public static void main(String[] argv) {
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(100);
        arr.add(25);
        arr.add(75);
        arr.add(15);
        arr.add(350);
        arr.add(300);
        arr.add(10);
        arr.add(50);
        arr.add(200);
        arr.add(400);
        arr.add(325);
        arr.add(375);

        BinaryTree.BinaryTreeNode root = BinaryTree.create_BST(arr);
//        BinaryTree.display_level_order(root);

        System.out.print("Perimeter:\n");
        display_tree_perimeter(root);
    }

}





//    Print Tree Perimeter
//        Given the root node of a binary tree, print the nodes that form the boundary (perimeter).
//
//        We'll cover the following
//        Try it yourself
//        Description
//        Given the root node of a binary tree, print the nodes that form the boundary (perimeter).
//
//        In the following tree, the highlighted nodes form the perimeter. The expected output for the below tree would be 1, 2, 4, 9, 8, 10, 7, 3.