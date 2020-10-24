package oldstudy;

import java.util.*;

public class LevelOrderTraversalOfBinaryTreeMySolution {



   static Map<Integer,List<BinaryTree.BinaryTreeNode>> map = new HashMap<>();
    public static void level_order_traversal_2(BinaryTree.BinaryTreeNode root) {

        if (root == null) {
            return;
        }

        Queue<BinaryTree.BinaryTreeNode> current_queue =
                new ArrayDeque<BinaryTree.BinaryTreeNode>();

        BinaryTree.BinaryTreeNode dummyNode = new BinaryTree.BinaryTreeNode();

        current_queue.add(root);
        current_queue.add(dummyNode);
        int counter =0;
        while (!current_queue.isEmpty()) {
            BinaryTree.BinaryTreeNode temp = current_queue.poll();
            System.out.print(temp.getValue() + ",");

            if (temp.left != null) {
                current_queue.add(temp.left);
            }

            if (temp.right != null) {
                current_queue.add(temp.right);
            }

            if (current_queue.peek() == dummyNode) {
                System.out.println();

                current_queue.remove();

                if (!current_queue.isEmpty()) {
                    current_queue.add(dummyNode);
                }
            }
        }
        System.out.println();

    }


    public static Map<Integer,List<BinaryTree.BinaryTreeNode>>  level_order_traversal_1(
            BinaryTree.BinaryTreeNode root) {

        if (root == null) {
            return null;
        }

        Queue<BinaryTree.BinaryTreeNode> current_queue =
                new ArrayDeque<BinaryTree.BinaryTreeNode>();

        BinaryTree.BinaryTreeNode dummyNode = new BinaryTree.BinaryTreeNode();

        current_queue.add(root);
        current_queue.add(dummyNode);

int counter = 0;
        List<BinaryTree.BinaryTreeNode> list = new ArrayList<>();
        while (!current_queue.isEmpty()) {
            BinaryTree.BinaryTreeNode temp = current_queue.poll();
            System.out.print(temp.getValue() + ",");

            list.add(temp);



            if (temp.left != null) {
                current_queue.add(temp.left);
            }

            if (temp.right != null) {
                current_queue.add(temp.right);
            }

            if (current_queue.peek() == dummyNode) {
                System.out.println();
                map.put(counter, list);
                counter++;
                list = new ArrayList<>();
                current_queue.remove();

                if (!current_queue.isEmpty()) {
                    current_queue.add(dummyNode);
                }
            }
        }
        System.out.println();

        return map;
    }

    public static void main(String[] argv) {

        List<Integer> input = new ArrayList<Integer>();
        input.add(100);
        input.add(50);
        input.add(200);
        input.add(25);
        input.add(75);
        input.add(350);
        BinaryTree.BinaryTreeNode root = BinaryTree.create_BST(input);
        level_order_traversal_2(root);
        System.out.println();


        System.out.print("Inorder = ");

    }

}
