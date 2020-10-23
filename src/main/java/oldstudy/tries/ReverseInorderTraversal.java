package oldstudy.tries;

import oldstudy.treesbook.BinaryTree;
import oldstudy.treesbook.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class ReverseInorderTraversal {
    public static int current_count = 0;

    public static BinaryTreeNode find_nth_highest_in_bst(
            BinaryTreeNode node,
            int n) {

        if (node == null) {
            return null;
        }

        BinaryTreeNode result =
                find_nth_highest_in_bst(node.right, n);

        if(result != null) {
            return result;
        }

        current_count++;
        if(n == current_count) {
            return node;
        }

        result =
                find_nth_highest_in_bst(node.left, n);

        if(result != null) {
            return result;
        }

        return null;
    }


//        InorderTreeIterator ite = new InorderTreeIterator();
//        List<BinaryTreeNode> nods = ite.inorder_using_iterator_to_nods_list(root);
//
//
//        if ( nth < nods.size()) {
//            return nods.get(nods.size() - nth);
//        } else { return null;}

    public static void main(String[] argv) {


        List<Integer> input = new ArrayList<>();
        input.add(100);
        input.add(200);
        input.add(350);
        input.add(125);
        input.add(50);
        input.add(75);
        input.add(25);

        BinaryTreeNode root = BinaryTree.create_BST(input);

        int n = 2;
        current_count = 0;
        BinaryTreeNode nth_highest_node = find_nth_highest_in_bst(root, n);
        System.out.println(String.format(" - %d highest node is %d",
                n, nth_highest_node.data));

        n = 1;
        current_count = 0;
        nth_highest_node = find_nth_highest_in_bst(root, n);
        System.out.println(String.format(" - %d highest node is %d",
                n, nth_highest_node.data));

        n = 5;
        current_count = 0;
        nth_highest_node = find_nth_highest_in_bst(root, n);
        System.out.println(String.format(" - %d highest node is %d",
                n, nth_highest_node.data));

        n = 30;
        current_count = 0;
        nth_highest_node = find_nth_highest_in_bst(root, n);
        System.out.println(String.format(" - %d highest node is %d",
                n, nth_highest_node));
    }
}
