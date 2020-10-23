package treesbook;

import treesbook.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class LevelOrderTraversal {
        // Using two queues
        public static void level_order_traversal_1(

                BinaryTreeNode root) {

                if (root == null) {
                        return;
                }

                ArrayList<Queue<BinaryTreeNode>> queues =
                        new ArrayList<Queue<BinaryTreeNode>>();

                queues.add(new ArrayDeque<BinaryTreeNode>());
                queues.add(new ArrayDeque<BinaryTreeNode>());

                Queue<BinaryTreeNode> current_queue = queues.get(0);
                Queue<BinaryTreeNode> next_queue = queues.get(1);

                current_queue.add(root);
                int level_number = 0;

                while (!current_queue.isEmpty()) {
                        BinaryTreeNode temp = current_queue.poll();
                        System.out.print(temp.data + ",");

                        if (temp.left != null) {
                                next_queue.add(temp.left);
                        }

                        if (temp.right != null) {
                                next_queue.add(temp.right);
                        }

                        if (current_queue.isEmpty()) {
                                System.out.println();
                                ++level_number;
                                current_queue = queues.get(level_number % 2);
                                next_queue = queues.get((level_number + 1) % 2);
                        }
                }
                System.out.println();
        }

        public static void level_order_traversal_2(
                BinaryTreeNode root) {

                if (root == null) {
                        return;
                }

                Queue<BinaryTreeNode> current_queue =
                        new ArrayDeque<BinaryTreeNode>();

                BinaryTreeNode dummyNode = new BinaryTreeNode(0);

                current_queue.add(root);
                current_queue.add(dummyNode);

                while (!current_queue.isEmpty()) {
                        BinaryTreeNode temp = current_queue.poll();
                        System.out.print(temp.data + ",");

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


        public static void main(String[] argv) {

                List<Integer> input = new ArrayList<Integer>();
                input.add(100);input.add(50);input.add(200);input.add(25);input.add(75);input.add(350);
                BinaryTreeNode root = BinaryTree.create_BST(input);
                level_order_traversal_2(root);
                System.out.println();


                System.out.print("Inorder = ");
                BinaryTree.display_inorder(root);

        }
}
