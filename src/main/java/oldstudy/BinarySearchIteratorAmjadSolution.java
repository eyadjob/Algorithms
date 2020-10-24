package oldstudy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

    public class BinarySearchIteratorAmjadSolution implements Iterator<BinarySearchIteratorAmjadSolution.BinaryTreeNode> {

    BinaryTreeNode root;
    Stack<BinaryTreeNode> stack = new Stack<>();

    public BinarySearchIteratorAmjadSolution(BinaryTreeNode root) {
        this.root = root;
        BinaryTreeNode p = root;
        if (p != null) {
            stack.push(p);
            while (p.left != null) {
                stack.push(p.left);
                p = p.left;
            }

        }
    }


    public static void inorder_using_iterator(BinaryTreeNode root) {
        BinarySearchIteratorAmjadSolution iter = new BinarySearchIteratorAmjadSolution(root);
        while (iter.hasNext()) {
            System.out.print(iter.next().value + ", ");
        }
        System.out.println();
    }

    @Override
    public boolean hasNext() {
        return !stack.empty();
    }

    @Override
    public BinaryTreeNode next() {
        BinaryTreeNode current = stack.pop();

        if (current.left == null && current.right == null) {
            return current;
        }


        if (current.right != null) {
            BinaryTreeNode currentTemp = current;


            current = current.right;
            stack.push(current);
            while (current.left != null) {
                stack.push(current.left);
                current = current.left;
            }
            return currentTemp;
        }
        return null;

    }

        public static void main(String[] args) {

            List<Integer> input = new ArrayList<Integer>();
            input.add(100);
            input.add(50);
            input.add(200);
            input.add(25);
            input.add(75);
            input.add(65);
            input.add(85);

            input.add(125);
            input.add(350);
            BinaryTreeNode root = BinaryTree.create_BST(input);
            inorder_using_iterator(root);
            System.out.println();
        }


        static class BinaryTreeNode {

        int value;

        BinaryTreeNode right;
        BinaryTreeNode left;

        @Override
        public String toString() {
            return "(" + value + " : \n\n" + left + "  " + right + ")";
        }
    }


    static class BinaryTree {

        public static BinaryTreeNode create_BST(List<Integer> input1) {
            BinaryTreeNode root = new BinaryTreeNode();
            root.value = input1.get(0);
            for (int i = 1; i < input1.size(); i++) {
                BinaryTreeNode newNode = new BinaryTreeNode();
                newNode.value = input1.get(i);
                addNode(root, newNode);


            }
            return root;

        }

        private static void addNode(BinaryTreeNode root, BinaryTreeNode newNode) {
            if (newNode.value >= root.value) {
                if (root.right == null) {
                    root.right = newNode;
                } else {
                    addNode(root.right, newNode);
                }
            } else {
                if (root.left == null) {
                    root.left = newNode;
                } else {
                    addNode(root.left, newNode);
                }
            }
        }

    }
}