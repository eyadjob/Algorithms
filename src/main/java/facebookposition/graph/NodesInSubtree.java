package facebookposition.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NodesInSubtree {

    public static void main(String[] args) {


        String s_1 = "aba";
        Node root_1 = new Node(1);
        root_1.children.add(new Node(2));
        root_1.children.add(new Node(3));
        ArrayList<Query> queries_1 = new ArrayList<>();
        queries_1.add(new Query(1, 'a'));
        int[] output_1 = countOfNodes(root_1, queries_1, s_1);
        System.out.println(Arrays.toString(output_1));
//        int[] expected_1 = {2};

//                    1234567
        String s_2 = "abaacab";
        Node root_2 = new Node(1);
        root_2.children.add(new Node(2));
        root_2.children.add(new Node(3));
        root_2.children.add(new Node(7));
        root_2.children.get(0).children.add(new Node(4));
        root_2.children.get(0).children.add(new Node(5));
        root_2.children.get(1).children.add(new Node(6));
        ArrayList<Query> queries_2 = new ArrayList<>();
        queries_2.add(new Query(1, 'a'));
        queries_2.add(new Query(2, 'b'));
        queries_2.add(new Query(3, 'a'));
        int[] output_2 = countOfNodes(root_2, queries_2, s_2);
//        int[] expected_2 = {4, 1, 2};
        System.out.println(Arrays.toString(output_2));


    }

    public static Node findNodByValue(Node root, int value) {
        Node node = root;
        Stack<Node> findNode = new Stack();
        findNode.add(node);
        while (!findNode.isEmpty()) {
            node = findNode.pop();
            if (node.val == value)
                break;
            if (node.children.size() != 0)
                findNode.addAll(node.children);
        }
        return node;
    }

    static int[] countOfNodes(Node root, ArrayList<Query> queries, String s) {
        int[] re = new int[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            char c = queries.get(i).c;
            Node node = findNodByValue(root, queries.get(i).u);
            Stack<Node> stack = new Stack();
            stack.add(node);
            while (!stack.isEmpty()) {
                node = stack.pop();
                if (s.charAt(node.val - 1) == c) re[i]++;
                if (node.children.size() != 0)
                    stack.addAll(node.children);
            }
        }
        return re;
    }


    static class Query {
        int u;
        char c;

        Query(int u, char c) {
            this.u = u;
            this.c = c;
        }
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
            val = 0;
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
