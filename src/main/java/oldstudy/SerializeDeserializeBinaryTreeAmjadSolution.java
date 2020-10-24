//import java.io.*;
//
//public class SerializeDeserializeBinaryTreeAmjadSolution {
//
//    private static BinaryTree.BinaryTreeNode deserialize(ObjectInputStream istream) throws IOException {
//
//        int i = istream.readInt();
//
//        if (i == Integer.MIN_VALUE) {
//            return null;
//        }
//
//
//        BinaryTree.BinaryTreeNode node = new BinaryTree.BinaryTreeNode();
//        node.value = i;
//
//
//        node.left = deserialize(istream);
//        node.right = deserialize(istream);
//
//
//        return node;
//
//    }
//
//    private static void serialize(BinaryTree.BinaryTreeNode root, ObjectOutputStream stream) throws IOException {
//
//        if (root == null) {
//            stream.writeInt(Integer.MIN_VALUE);
//            return;
//        }
//
//        stream.writeInt(root.value);
//        serialize(root.left, stream);
//        serialize(root.right, stream);
//
//    }
//
//
//    public static void main(String[] args) {
//        try {
//            BinaryTree.BinaryTreeNode root = BinaryTree.create_random_BST(15, 100);
//
//            BinaryTree.display_inorder(root);
//
//            ByteArrayOutputStream baostream = new ByteArrayOutputStream();
//            ObjectOutputStream stream = new ObjectOutputStream(baostream);
//            serialize(root, stream);
//            stream.close();
//
//            ByteArrayInputStream baistream = new ByteArrayInputStream(
//                    baostream.toByteArray());
//            ObjectInputStream istream = new ObjectInputStream(baistream);
//            BinaryTree.BinaryTreeNode root_deserialized = deserialize(istream);
//
//            System.out.println("\nResult");
//            BinaryTree.display_inorder(root_deserialized);
//
//            System.out.println(BinaryTree.is_identical_tree(root,
//                    root_deserialized));
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//}
//
////  [22:39, 4/19/2019] امجد عبد الغني: Serialize/Deserialize Binary Tree
////    Serialize a binary tree to a file and then deserialize it back to a tree so that the original and the deserialized trees are identical.
////
////            We'll cover the following
////    Try it yourself
////            Description
////    Serialize a binary tree to a file and then deserialize it back to a tree so that the original and the deserialized trees are identical.
////
////            Serialize: write the tree in a file.
////
////    Deserialize: read from a file and reconstruct the tree in memory.
////
////    Consider the below tree as the input tree.