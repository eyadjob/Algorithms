package oldstudy;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class BinaryTree {


    static BinaryTreeNode head = new BinaryTreeNode();
    BinaryTree.BinaryTreeNode root;
    Stack<BinaryTree.BinaryTreeNode> stack = new Stack<>();

//    public static ArrayList<Integer> bst_to_arraylist(BinaryTree.BinaryTreeNode root) {
//        BinaryTreeIterator iterator = new BinaryTreeIterator(root);
//        ArrayList list = new ArrayList();
//        while (iterator.hasNext()) {
//            list.add(iterator.next().);
//        }
//        return list;
//    }
//
//
//    public static boolean is_identical_tree(BinaryTreeNode root, BinaryTreeNode root_deserialized) {
//
//        return bst_to_arraylist(root).equals(bst_to_arraylist(root_deserialized));
//
//    }
//
//
//
//    public static void display_inorder(BinaryTreeNode root) {
//
//        System.out.println(bst_to_arraylist(root));
//    }


    BinaryTree(BinaryTree.BinaryTreeNode root) {
        this.root = root;
        BinaryTree.BinaryTreeNode p = root;
        if (p != null) {
            stack.push(p);
            while (p.left != null) {
                stack.push(p.left);
                p = p.left;
            }

        }
    }

    public static void display_level_order(BinaryTreeNode root) {
        LevelOrderTraversalOfBinaryTreeMySolution.level_order_traversal_2(root);

    }

    public static BinaryTreeNode create_binary_tree(int i) {

        return null;


    }

    public static BinaryTreeNode create_random_BST(int n, int max) {
        List<Integer> list = new ArrayList<>(n);
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(100));
        }

        return create_BST(list);
    }

    public static BinaryTreeNode create_BST(List<Integer> input1) {

        for (int i = 0; i < input1.size(); i++) {
            if (i == 0) {
                BinaryTreeNode nod = new BinaryTreeNode();
                nod.setValue(input1.get(i));
                head = nod;


            } else {
                setNodValue(head, input1.get(i));

            }

        }

        return head;
    }

    public static void setNodValue(BinaryTreeNode headN, Integer v) {
        if (v < headN.getValue()) {
            if (headN.getLeft() == null) {
                BinaryTreeNode nod = new BinaryTreeNode();
                nod.setValue(v);
                headN.setLeft(nod);
            } else {
                setNodValue(headN.getLeft(), v);
            }

        } else {
            if (headN.getRight() == null) {
                BinaryTreeNode nod = new BinaryTreeNode();
                nod.setValue(v);
                headN.setRight(nod);
            } else {
                setNodValue(headN.getRight(), v);
            }

        }
    }

    public boolean hasNext() {
        return !stack.empty();
    }

    public BinaryTreeNode next() {
        BinaryTreeNode current = stack.pop();

        if (current.left == null && current.right == null) {
            return current;
        }


        if (current.right != null) {
            BinaryTree.BinaryTreeNode currentTemp = current;


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

    @Data
    public static class BinaryTreeNode {
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode next;
        Integer value;

        public void setValue(Integer value) {
            this.value = value;
        }


    }
}
