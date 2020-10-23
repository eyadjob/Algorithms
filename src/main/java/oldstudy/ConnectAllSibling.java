//import java.util.ArrayList;
//import java.util.List;
//
//public class ConnectAllSibling {
//
//
//    public static void populate_sibling_pointers(BinaryTree.BinaryTreeNode root) {
//
//    }
//
//    public static List<Integer> get_level_order_traversal_with_sibling(BinaryTree.BinaryTreeNode root) {
//
//
//    }
//
//
//
//    public static void main(String[] args) {
//
//        List<Integer> input = new ArrayList<Integer>();
//        input.add(100);input.add(25);input.add(75);input.add(15);input.add(350);input.add(300);input.add(10);
//        input.add(50);input.add(200);input.add(400);input.add(325);input.add(375);
//        BinaryTree.BinaryTreeNode root = BinaryTree.create_BST(input);
//
//        BinaryTree.display_level_order(root);
//        populate_sibling_pointers(root);
//
//        System.out.println("Root -> next: "+ root.next.getData()); //25
//        System.out.println("Root->right->left->next: "+ root.right.left.next.getData()); //400
//        System.out.println("Root->right->right->next: "+ root.right.right.next.getData()); //10
//        System.out.println("Root->right->right->left->next: "+ root.right.right.left.next); //None
//
//        List<Integer> l1 = BinaryTree.display_level_order(root);
//        List<Integer> l2 = get_level_order_traversal_with_sibling(root);
//        System.out.println("Connected? = "+ Boolean.toString(ListUtil.is_equal(l1, l2)));
//        System.out.println();
//        ListUtil.print(l1);
//    }
//}
