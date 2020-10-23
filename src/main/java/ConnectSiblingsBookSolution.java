import java.util.ArrayList;
import java.util.List;

public class ConnectSiblingsBookSolution {

    
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

//            List<Integer> v1 = LevelOrderTraversalOfBinaryTreeMySolution.level_order_traversal_2(head);
//            System.out.println(v1);
            //            System.out.println("Siblings Connected : " + Arrays.deepEquals(v1.toArray(), result.toArray()));
            populate_sibling_pointers(head);

            List<Integer> result = get_level_order_using_next(head);
            System.out.println(result);

            System.out.println("Result Tree: " + result);
            System.out.println("100 -> next: " + head.next); //null
            System.out.println("25 -> next: " + head.left.next.getValue()); //350
            System.out.println("75 -> next: " + head.left.right.next.getValue()); //300
            System.out.println("300 -> next: " + head.right.right.next); //null


        }

        static List<Integer> get_level_order_using_next(BinaryTree.BinaryTreeNode root) {
            List<Integer> output = new ArrayList<Integer>();
            while (root != null) {
                BinaryTree.BinaryTreeNode head = root;
                BinaryTree.BinaryTreeNode next_head = null;
                while (head != null) {
                    output.add(head.getValue());

                    if (next_head == null) {
                        next_head = head.left != null ? head.left : head.right;
                    }

                    head = head.next;
                }
                root = next_head;
            }
            return output;
        }

        private static void populate_sibling_pointers(BinaryTree.BinaryTreeNode head) {

            if (head == null) {
                return;
            }
            head.next = null;

            do {

                head = getNext(head);

            } while (head != null);


        }

        private static BinaryTree.BinaryTreeNode getNext(BinaryTree.BinaryTreeNode head) {
            BinaryTree.BinaryTreeNode current = head;
            BinaryTree.BinaryTreeNode nextHead = null;
            BinaryTree.BinaryTreeNode pre = null;
            while (current != null) {
                if (current.left != null && current.right != null) {
                    if (nextHead == null) {
                        nextHead = current.left;
                    }
                    current.left.next = current.right;
                    if (pre != null) {
                        pre.next = current.left;

                    }
                    pre = current.right;
                } else if (current.left != null) {
                    if (nextHead == null) {
                        nextHead = current.left;
                    }

                    if (pre != null) {
                        pre.next = current.left;

                    }
                    pre = current.left;


                } else if (current.right != null) {
                    if (nextHead == null) {
                        nextHead = current.right;
                    }

                    if (pre != null) {
                        pre.next = current.right;
                    }

                    pre = current.right;
                }

                current = current.next;
            }
            if (pre != null) {
                pre.next = null;
            }
            return nextHead;
        }
    }
