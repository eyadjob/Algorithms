import java.util.ArrayList;
import java.util.List;

public class CheckIfBinaryTree {

    public static BinaryTree.BinaryTreeNode temp = new BinaryTree.BinaryTreeNode();
//    static Stack<BinaryTree.BinaryTreeNode> s = new Stack<>();
//    static ArrayList<BinaryTree.BinaryTreeNode> a = new ArrayList<>();

    private static boolean is_binary_search_tree(BinaryTree.BinaryTreeNode root) {
        return is_binary_search_tree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }


    private static boolean is_binary_search_tree(BinaryTree.BinaryTreeNode root, int min , int max) {

        if(root == null){
            return true;
        }
        if( root.getValue() < min || root.getValue() > max){
            return false;
        }

        return is_binary_search_tree(root.left, min, root.getValue()) && is_binary_search_tree(root.right, root.getValue(), max);

    }

    public static void main(String[] argv) {

//        BinaryTree.BinaryTreeNode root = BinaryTree.create_crandom_BST(5,100);
        List<Integer> input1 = new ArrayList<Integer>();
        input1.add(100);
        input1.add(50);
        input1.add(200);
        input1.add(25);
        input1.add(125);
        input1.add(250);
        BinaryTree.BinaryTreeNode root2 = BinaryTree.create_BST(input1);
        BinaryTree.BinaryTreeNode root = BinaryTree.create_BST(input1);
        LevelOrderTraversalOfBinaryTreeMySolution.level_order_traversal_2(root);
        System.out.println();
        System.out.println("Is it BST?: " + is_binary_search_tree(root));
//
//        BinaryTree.BinaryTreeNode root2 = BinaryTree.create_binary_tree(5);
//        System.out.println();
//        LevelOrderTraversalOfBinaryTreeMySolution.level_order_traversal_2(root2);

//        System.out.println("Is it BST?: " + Boolean.toString(is_binary_search_tree(root2)));
    }

}


//    Is Binary Search Tree?
//        Given a binary tree, figure out whether it's a BST.
//
//        We'll cover the following
//        Try it yourself
//        Description
//        Given a Binary Tree, figure out whether it's a Binary Search Tree. In a binary search tree, each node's key data is smaller than the key data of all nodes in the right subtree, and are greater than the key values of all nodes in the left subtree i.lines. L < N < R.
//        Below binary tree is a valid BST.
