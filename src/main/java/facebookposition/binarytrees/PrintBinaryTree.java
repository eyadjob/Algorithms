package facebookposition.binarytrees;

public class PrintBinaryTree {

    static int counter = 0;
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(4);
        bt.root.ln = new Nod(7);
        bt.root.rn = new Nod(9);
        bt.root.rn.rn = new Nod(6);
        bt.root.ln.ln = new Nod(10);
        bt.root.ln.rn = new Nod(2);
        bt.root.ln.rn.rn = new Nod(6);
        bt.root.ln.rn.rn.ln = new Nod(2);
        printBTDepthFirst(bt.root);
        System.out.println();
        System.out.println("-------------------------------------");
        printBTBreadthFirst(bt.root);
    }

    public static void printBTDepthFirst(Nod root) {
        if (root == null) {
            return;
        }
        System.out.println(root.v);
        printBTDepthFirst(root.ln);
        printBTDepthFirst(root.rn);
    }

    public static void printBTBreadthFirst(Nod root) {
        if ( root == null) {
            return;
        }

//        System.out.println(root.v);
        System.out.println(root.ln != null ? root.ln.v : "null");
        System.out.println(root.rn != null ? root.rn.v : "null");
        printBTBreadthFirst(root.ln);


    }


}
