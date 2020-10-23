package oldstudy.treesbook;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BinaryTree {

   public BinaryTreeNode root;


   public BinaryTreeNode getRoot() {
      return  this.root;
    }
    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }

    public static BinaryTreeNode create_BST(List<Integer> input) {
        BinaryTreeNode root = new BinaryTreeNode();
        root.data = input.get(0);
        for (int i = 1; i < input.size(); i++) {
            BinaryTreeNode newNode = new BinaryTreeNode();
            newNode.data = input.get(i);
            addNode(root, newNode);

        }
        return root;
    }




    public static void addNode(BinaryTreeNode root, BinaryTreeNode newNode) {
        if (newNode.data >= root.data) {
            if (root.right == null) {
                root.right = newNode;
                newNode.parent = root;
            } else {
                addNode(root.right, newNode);
            }
        } else {
            if (root.left == null) {
                root.left = newNode;
                newNode.parent = root;
            } else {
                addNode(root.left, newNode);
            }
        }
    }

    public static void display_inorder(BinaryTreeNode root) {
        System.out.println(bst_to_list(root));
    }


    public static void display_level_order(BinaryTreeNode root) {
        LevelOrderTraversal.level_order_traversal_2(root);

    }

    public static List<Integer> bst_to_list(BinaryTreeNode root) {
        List<Integer> tree = new ArrayList<>();
        InorderTreeIterator iterator = new InorderTreeIterator();
        tree = iterator.inorder_using_iterator_to_list(root);
        return tree;
    }
}
