package tries;

import treesbook.BinaryTree;
import treesbook.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InorderTraversalWithPointer {
    static BinaryTreeNode find_min_in_tree(
            BinaryTreeNode root) {

        if(root == null)
            return null;

        while(root.left != null) {
            root = root.left;
        }

        return root;
    }

    static BinaryTreeNode inorder_successor_bst_parent_pointer(
            BinaryTreeNode node){

        if(node == null) {
            return null;
        }

        if(node.right != null)
        {
            return find_min_in_tree(node.right);
        }

        while(node.parent != null)
        {
            if(node.parent.left == node){
                return node.parent;
            }
            node = node.parent;
        }

        return null;
    }

    static BinaryTreeNode find_successor(
            BinaryTreeNode root, int d) {
        while (root != null) {

            if(root.data < d) {
                root = root.right;
            } else if(root.data > d) {
                root = root.left;
            } else {
                return inorder_successor_bst_parent_pointer(root);
            }
        }
        return null;
    }


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(100);
        list.add(50);
        list.add(25);
        list.add(75);
        list.add(80);
        list.add(200);
        list.add(125);
        list.add(350);

//        List<Integer> orig_data = BinaryTree.create_BST(list);

        BinaryTreeNode root = BinaryTree.create_BST(list);
        BinaryTree.display_inorder(root);
        System.out.println();
//        BinaryTree.populate_parents(root);

        List<Integer> all_data = BinaryTree.bst_to_list(root);
        List<Integer> all_data_copy = new ArrayList<Integer>();
        all_data_copy.addAll(all_data);
        Collections.shuffle(all_data_copy);

        for (Integer d : all_data_copy) {
            //BinaryTreeNode node = BinaryTree.find_in_bst(root, d);
            BinaryTreeNode successor = find_successor(root, d);
            int i = all_data.indexOf(d);
            Integer expected_val = null;
            if (i < all_data.size() - 1) {
                expected_val = all_data.get(i + 1);
            }

            if (successor != null) {
                if (expected_val.intValue() != successor.data) {
                    System.out.println("*******" + d + " ==== " + expected_val + ", " + successor.data + "*****");
                    System.out.println(expected_val.intValue() == successor.data);
                }
            } else
                System.out.println("Successor == null? " + (successor == null));

            if (successor != null)
                System.out.print("(" + d + ", " + successor.data + ") ");
            else
                System.out.print("(" + d + ", null) ");
        }
    }

}
