package oldstudy.graphsbook;

import java.util.*;

public class CloneGraphBook {


    public static HashMap visited = new HashMap();


    public static GraphNod clone = new GraphNod(-1);

    public static int counter = 0;


    public static ArrayList<GraphNod> create_test_graph_undirected(int nodes_count, int edges_count) {
        ArrayList<GraphNod> vertices = new ArrayList<GraphNod>();
        for (int i = 0; i < nodes_count; ++i) {
            vertices.add(new GraphNod(i));
        }

        List<Pair<Integer, Integer>> all_edges = new ArrayList<Pair<Integer, Integer>>();
        for (int i = 0; i < vertices.size(); ++i) {
            for (int j = i + 1; j < vertices.size(); ++j) {
                all_edges.add(new Pair<Integer, Integer>(i, j));
            }
        }

        Collections.shuffle(all_edges);

        for (int i = 0; i < edges_count && i < all_edges.size(); ++i) {
            Pair<Integer, Integer> edge = all_edges.get(i);
            vertices.get(edge.first).neighbors.add(vertices.get(edge.second));
            vertices.get(edge.second).neighbors.add(vertices.get(edge.first));
        }

        return vertices;
    }

    private static GraphNod clone_rec(
            GraphNod root,
            HashMap<GraphNod, GraphNod> nodes_completed) {
        counter++;
        if (root == null) {
            return null;
        }

        GraphNod pNew = new GraphNod(root.data);
        nodes_completed.put(root, pNew);

        for (GraphNod p : root.neighbors) {
            GraphNod x = nodes_completed.get(p);
            if (x == null) {
                pNew.neighbors.add(clone_rec(p, nodes_completed));
            } else {
                pNew.neighbors.add(x);
            }
        }
        return pNew;
    }

    public static GraphNod clone(GraphNod root) {
        HashMap<GraphNod, GraphNod> nodes_completed =
                new HashMap<GraphNod, GraphNod>();

        return clone_rec(root, nodes_completed);
    }

    public static void main(String[] args) {
        ArrayList<GraphNod> vertices = create_test_graph_undirected(7, 18);

        Graph.print_graph(vertices.get(0));

        GraphNod cp = oldstudy.graphsbook.CloneGraphBook.clone(vertices.get(0));
        System.out.println();
        System.out.println("After copy.");
        Graph.print_graph(cp);
        System.out.println("counter vlaue is : " + counter);
//        vertices.get(1).data = 100;
//        Graph.print_graph(cp);

        HashSet<GraphNod> set = new HashSet<GraphNod>();
        System.out.println(Graph.are_graphs_equal_rec(vertices.get(0), cp, set));
    }


}
