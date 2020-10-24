package oldstudy.graphsbook;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Data
public class Graph {

    private List<GraphNod> nods;   //GraphNod
    private List<Line> lines;


    public Graph(List<GraphNod> nods, List<Line> lines) {
        super();
        this.nods = nods;
        this.lines = lines;
    }

    static void print_graph(List<GraphNod> vertices) {
        for (GraphNod n : vertices) {
            System.out.print(n.data + ": {");
            for (GraphNod t : n.neighbors) {
                System.out.print(t.data + " ");
            }
            System.out.println();
        }
    }

    static void print_graph(GraphNod root, HashSet<GraphNod> visited_GraphNods) {
        if (root == null || visited_GraphNods.contains(root)) {
            return;
        }

        visited_GraphNods.add(root);

        System.out.print(root.data + ": {");
        for (GraphNod n : root.neighbors) {
            System.out.print(n.data + " ");
        }
        System.out.println("}");

        for (GraphNod n : root.neighbors) {
            print_graph(n, visited_GraphNods);
        }
    }

    static void print_graph(GraphNod root) {
        HashSet<GraphNod> visited_GraphNods = new HashSet<GraphNod>();
        print_graph(root, visited_GraphNods);
    }


    static boolean are_graphs_equal_rec(GraphNod root1, GraphNod root2, HashSet<GraphNod> visited) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.data != root2.data) {
            return false;
        }

        if (root1.neighbors.size() != root2.neighbors.size()) {
            return false;
        }

        for (GraphNod nbr1 : root1.neighbors) {
            boolean found = false;
            for (GraphNod nbr2 : root2.neighbors) {
                if (nbr1.data == nbr2.data) {
                    if (!visited.contains(nbr1)) {
                        visited.add(nbr1);
                        are_graphs_equal_rec(nbr1, nbr2, visited);
                    }
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }

        return true;
    }

    void generate_graph(int vertices,
                        List<ArrayList<Integer>> edges) {
        // create vertices
        for (int i = 0; i < vertices; i++) {
            GraphNod v = new GraphNod(i + 1, false);
            nods.add(v);
        }

        for (int i = 0; i < edges.size(); i++) {
            GraphNod src = vertex_exists(edges.get(i).get(1));
            GraphNod dest = vertex_exists(edges.get(i).get(2));
            Line e = new Line(edges.get(i).get(0), false, src,
                    dest);
            getLines().add(e);
        }
    }

    GraphNod vertex_exists(int id) {
        for (int i = 0; i < nods.size(); i++) {
            if (nods.get(i).getId() == id) {
                return nods.get(i);
            }
        }
        return null;
    }



    void print_mst(int w) {
        System.out.println("MST");
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).isVisited() == true) {
                System.out.println(lines.get(i).getSrc().getId() + "->"
                        + lines.get(i).getDest().getId());
            }
        }
        System.out.println("weight: " + w);
        System.out.println();
    }



    }