package oldstudy.graphsbook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumSpanningTree {

    List<GraphNod> vis = new ArrayList<>();

   public static int find_min_spanning_tree(Graph g) {
        int vertex_count = 0;
        int weight = 0;

        // Add first vertex to the MST
        GraphNod current = g.getNods().get(0);
        current.setVisited(true);
        vertex_count++;

        // Construct the remaining MST using the
        // smallest weight edge
        while (vertex_count < g.getNods().size()) {
            Line smallest = null;
            for (int i = 0; i < g.getLines().size(); i++) {
                if (!g.getLines().get(i).isVisited()) {
                    if (g.getLines().get(i).getSrc().isVisited()
                            && !g.getLines().get(i).getDest().isVisited()) {
                        if (smallest == null) {
                            smallest = g.getLines().get(i);
                        } else if (g.getLines().get(i).getWeight() < smallest.getWeight()) {
                            smallest = g.getLines().get(i);
                        }
                    }
                }
            }

            smallest.setVisited(true);
            smallest.getDest().setVisited(true);
            weight += smallest.getWeight();
            vertex_count++;
        }
        return weight;
    }

    public static void test_graph1() {
        Graph g = new Graph(new ArrayList<GraphNod>(),
                new ArrayList<Line>());
        int v = 5;

        // each edge contains the following: weight, src, dest
        ArrayList<Integer> e1 = new ArrayList<Integer>(
                Arrays.asList(1, 1, 2));
        ArrayList<Integer> e2 = new ArrayList<Integer>(
                Arrays.asList(1, 1, 3));
        ArrayList<Integer> e3 = new ArrayList<Integer>(
                Arrays.asList(2, 2, 3));
        ArrayList<Integer> e4 = new ArrayList<Integer>(
                Arrays.asList(3, 2, 4));
        ArrayList<Integer> e5 = new ArrayList<Integer>(
                Arrays.asList(3, 3, 5));
        ArrayList<Integer> e6 = new ArrayList<Integer>(
                Arrays.asList(2, 4, 5));

        List<ArrayList<Integer>> e = new ArrayList<ArrayList<Integer>>();
        e.add(e1);
        e.add(e2);
        e.add(e3);
        e.add(e4);
        e.add(e5);
        e.add(e6);

        g.generate_graph(v, e);
        System.out.println("Testing graph 1...");
        // nods.print_graph();
        int w = find_min_spanning_tree(g);
        g.print_mst(w);
    }

    public static void test_graph2() {
        Graph g = new Graph(new ArrayList<GraphNod>(),
                new ArrayList<Line>());
        int v = 7;

        // each edge contains the following: weight, src, dest
        ArrayList<Integer> e1 = new ArrayList<Integer>(
                Arrays.asList(2, 1, 4));
        ArrayList<Integer> e2 = new ArrayList<Integer>(
                Arrays.asList(1, 1, 3));
        ArrayList<Integer> e3 = new ArrayList<Integer>(
                Arrays.asList(2, 1, 2));
        ArrayList<Integer> e4 = new ArrayList<Integer>(
                Arrays.asList(1, 3, 4));
        ArrayList<Integer> e5 = new ArrayList<Integer>(
                Arrays.asList(3, 2, 4));
        ArrayList<Integer> e6 = new ArrayList<Integer>(
                Arrays.asList(2, 3, 5));
        ArrayList<Integer> e7 = new ArrayList<Integer>(
                Arrays.asList(2, 4, 7));
        ArrayList<Integer> e8 = new ArrayList<Integer>(
                Arrays.asList(1, 5, 6));
        ArrayList<Integer> e9 = new ArrayList<Integer>(
                Arrays.asList(2, 5, 7));

        List<ArrayList<Integer>> e = new ArrayList<ArrayList<Integer>>();
        e.add(e1);
        e.add(e2);
        e.add(e3);
        e.add(e4);
        e.add(e5);
        e.add(e6);
        e.add(e7);
        e.add(e8);
        e.add(e9);

        g.generate_graph(v, e);
        System.out.println("Testing graph 2...");
        // nods.print_graph();
        int w = find_min_spanning_tree(g);
        g.print_mst(w);
    }


    public static void main(String[] args) {
        MinimumSpanningTree.test_graph1();
        test_graph2();

        System.out.println("Completed!");
    }

}
