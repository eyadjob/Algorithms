package facebookposition.binarytrees;

public class NumberOfVisibleNodesOnLeftSide {
    public static void main(String[] args) {

    }

    int visibleNodes(Node root) {
        // Write your code here
        return 0;
    }

}
class Node {
    int data;
    Node left;
    Node right;
    Node() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }
    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

//Signature
//        int visibleNodes(Node root) {
//        Input
//        The root node of a tree, where the number of nodes is between 1 and 1000, and the value of each node is between 0 and 1,000,000,000
//        Output
//        An int representing the number of visible nodes.
//        Example
//        8  <------ root
//        / \
//        3    10
//        / \     \
//        1   6     14
//        / \    /
//        4   7  13
//        output = 4
