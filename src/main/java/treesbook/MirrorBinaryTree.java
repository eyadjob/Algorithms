package treesbook;

import treesbook.BinaryTree;
import treesbook.BinaryTreeNode;

import java.util.ArrayList;

public class MirrorBinaryTree{


    public static BinaryTreeNode mirror_binary_tree(BinaryTreeNode root ) {

        if(root == null){
            return null;
        }

        BinaryTreeNode left = root.left;
        root.left = root.right;
        root.right =left;

        mirror_binary_tree(root.left);
        mirror_binary_tree(root.right);

        return root;
    }




    public static void main(String[] argv) {
        ArrayList<Integer> orig_data = new ArrayList<Integer>();
        orig_data.add(100);
        orig_data.add(50);
        orig_data.add(25);
        orig_data.add(75);
        orig_data.add(80);
        orig_data.add(200);
        orig_data.add(125);
        orig_data.add(350);
        BinaryTreeNode root = BinaryTree.create_BST(orig_data);

        BinaryTree.display_level_order(root);
        System.out.println();

        mirror_binary_tree(root);

        BinaryTree.display_level_order(root);
    }
}
