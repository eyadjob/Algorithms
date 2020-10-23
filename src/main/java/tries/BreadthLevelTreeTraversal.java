package tries;

import treesbook.BinaryTree;
import treesbook.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BreadthLevelTreeTraversal {


    public static void level_order_traversal_2(BinaryTreeNode root) {

        if (root == null)
            return;

        Queue<BinaryTreeNode> qu = new ArrayDeque<>();
        BinaryTreeNode dummy = new BinaryTreeNode();
        qu.add(root);
        qu.add(dummy);

        while (!qu.isEmpty()) {
            BinaryTreeNode nod = qu.poll();
            System.out.print(nod.data + ",");

            if (nod.left != null) {
                qu.add(nod.left);
            }

            if (nod.right != null) {
                qu.add(nod.right);
            }

            if (qu.peek() == dummy) {
                System.out.println();
                qu.remove();
                if (!qu.isEmpty()) {
                    qu.add(dummy);

                }
            }

        }
    }

    public static void main(String[] argv) {
        List<Integer> input = new ArrayList<Integer>();
        input.add(100);
        input.add(50);
        input.add(200);
        input.add(25);
        input.add(75);
        input.add(350);
        BinaryTreeNode root = BinaryTree.create_BST(input);
        level_order_traversal_2(root);
        System.out.println();

        System.out.print("Inorder = ");
        BinaryTree.display_inorder(root);

    }

}
