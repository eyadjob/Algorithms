package AmazonQuestions;

import treesbook.BinaryTree;
import treesbook.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class SymetricTree {


    public static boolean isMirror(BinaryTreeNode root) {



        return false;


    }



    public static void main(String[] args) {


        List<Integer> input1 = new ArrayList<Integer>();
        input1.add(100);
        input1.add(50);
        input1.add(50);
        input1.add(25);
        input1.add(25);

        BinaryTreeNode root = BinaryTree.create_BST(input1);

        System.out.println(isMirror(root));

    }
}
