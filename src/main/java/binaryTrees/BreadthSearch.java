package binaryTrees;

import treesbook.BinaryTree;
import treesbook.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthSearch {

    public static Queue<BinaryTreeNode> queue = new LinkedList<>();

    public static void printTreeBreadthSearch2(BinaryTreeNode root){

        if ( root == null)
            return ;

        queue.add(root);

        while(!queue.isEmpty()) {

            BinaryTreeNode node = queue.remove();
            System.out.println("printed node is : " + node.data);

            if ( root.left != null) {
                printTreeBreadthSearch2(node);
            }

            if (root.right != null) {
                printTreeBreadthSearch2(node);
            }
        }


    }

    public static void printTreeBreadthSearch(BinaryTreeNode root) {


        Queue<BinaryTreeNode> queue = new LinkedList<>();

        if ( root == null) {
            return;
        }

        queue.add(root);

        while(!queue.isEmpty() ) {

            BinaryTreeNode node = queue.remove();

            System.out.println("printed node is : " + node.data);

            if ( node.left != null) {
                queue.add(node.left);

            }

            if ( node.right != null) {
                queue.add(node.right);
            }

        }

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

        printTreeBreadthSearch(root);

    }

}
