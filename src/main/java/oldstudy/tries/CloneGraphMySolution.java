//package oldstudy.tries;
//
//import oldstudy.graphsbook.Graph;
//import oldstudy.graphsbook.GraphNod;
//import oldstudy.graphsbook.Pair;
//
//import java.util.*;
//
//public class CloneGraphMySolution {
//
//    public static HashMap<GraphNod, GraphNod> visited = new HashMap();
//
//
//    public static GraphNod clone = new GraphNod(-1);
//
//    public static int counter = 0;
//
//
//    public static ArrayList<GraphNod> create_test_graph_undirected(int nodes_count, int edges_count) {
//        ArrayList<GraphNod> vertices = new ArrayList<GraphNod>();
//        for (int i = 0; i < nodes_count; ++i) {
//            vertices.add(new GraphNod(i));
//        }
//
//        List<Pair<Integer, Integer>> all_edges = new ArrayList<Pair<Integer, Integer>>();
//        for (int i = 0; i < vertices.size(); ++i) {
//            for (int j = i + 1; j < vertices.size(); ++j) {
//                all_edges.add(new Pair<Integer, Integer>(i, j));
//            }
//        }
//
//        Collections.shuffle(all_edges);
//
//        for (int i = 0; i < edges_count && i < all_edges.size(); ++i) {
//            Pair<Integer, Integer> edge = all_edges.get(i);
//            vertices.get(edge.first).neighbors.add(vertices.get(edge.second));
//            vertices.get(edge.second).neighbors.add(vertices.get(edge.first));
//        }
//
//        return vertices;
//    }
//
//
//    public static GraphNod cloneGraph(GraphNod root) {
//
//        return clone_rec(root, visited);
//    }
//
//    private static GraphNod clone_rec(GraphNod o, Map<GraphNod, GraphNod> completed) {
//        counter++;
//        if (o == null) {
//            return null;
//        }
//
//            GraphNod n = new GraphNod(o.data);
//            completed.put(o, n);
//
//        for (GraphNod nods : o.neighbors) {
//            GraphNod x = visited.get(nods);
//            if (x == null) {
//               n.neighbors.add(clone_rec(nods, completed)) ;
//
//            } else {
//                n.neighbors.add(x);
//            }
//        }
//        return n;
//
//    }
//
//
//    public static void main(String[] args) {
//        ArrayList<GraphNod> vertices = create_test_graph_undirected(7, 18);
//
//        Graph.print_graph(vertices.get(0));
//
//        GraphNod cp = CloneGraphMySolution.cloneGraph(vertices.get(0));
//        System.out.println();
//        System.out.println("After copy.");
//        Graph.print_graph(cp);
//        System.out.println("counter vlaue is : " + counter);
//
//        HashSet<GraphNod> set = new HashSet<GraphNod>();
//        System.out.println(Graph.are_graphs_equal_rec(vertices.get(0), cp, set));
//    }
//
//
//}
