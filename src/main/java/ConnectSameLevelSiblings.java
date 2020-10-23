import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConnectSameLevelSiblings {


    public static void populate_sibling_pointers(BinaryTree.BinaryTreeNode root) {
       Map<Integer,List<BinaryTree.BinaryTreeNode>> map =  LevelOrderTraversalOfBinaryTreeMySolution.level_order_traversal_1(root);


       for ( int i =0; i < map.size(); i++) {

         List<BinaryTree.BinaryTreeNode>  list = map.get(i);

         for ( int k =0; k < list.size(); k++) {
             if ( k+1 != list.size()) {
                 list.get(k).setNext(list.get(k + 1));
             } else { list.get(k).setNext(null);}
         }
       }
//        if (root != null) {
//            if (root.getLeft() != null) {
//                root.getLeft().next = root.getRight();
//                populate_sibling_pointers(root.getLeft());
//                populate_sibling_pointers(root.getRight());
//            } else {
//                root.next = root.getRight();
//                return;
//            }
//
//            if (root.getRight() != null) {
//                root.getLeft().next = root.getRight();
//                populate_sibling_pointers(root.getLeft());
//                populate_sibling_pointers(root.getRight());
//            } else {
//                root.next = null;
//                return;
//            }
//        } else {
//            return;
//        }


    }


    public static List<Integer> get_level_order(BinaryTree.BinaryTreeNode root) {

        return null;
    }

    public static void main(String[] args) {
        List<Integer> v = new ArrayList<Integer>();
        v.add(100);
        v.add(25);
        v.add(75);
        v.add(15);
        v.add(350);
        v.add(300);
        v.add(10);
        v.add(50);
        v.add(200);
        v.add(400);
        v.add(325);
        v.add(375);

        BinaryTree.BinaryTreeNode head = BinaryTree.create_BST(v);

//        List<BinaryTree.BinaryTreeNode> result = LevelOrderTraversalOfBinaryTreeMySolution.level_order_traversal_1(head);

        populate_sibling_pointers(head);

//        List<Integer> result = get_level_order_using_next(head);

//        System.out.println("Result Tree: "+result);
        System.out.println("Result Tree: " + head);
        System.out.println("100 -> next: " + head.next); //null
        System.out.println("25 -> next: " + head.left.next.getValue()); //350
        System.out.println("75 -> next: " + head.left.right.next.getValue()); //300
        System.out.println("300 -> next: " + head.right.right.next); //null
//        System.out.println("Siblings Connected : " + ListUtil.is_equal(v1, result));
    }
}


//    Connect Same Level Siblings
//    Given a binary tree, connect its siblings at each level.
//
//        We'll cover the following
//        Try it yourself
//        Description
//        Given a binary tree, connect its siblings at each level. Let's consider the following binary tree as an example.
