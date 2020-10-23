package oldstudy.graphsbook;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GraphNod {

    private int id;
    private boolean visited;
    public int data;
    public List<GraphNod> neighbors = new ArrayList<GraphNod>();

    public GraphNod(int d) {
        data = d;
    }

    public GraphNod(int id, boolean visited) {
        super();
        this.id = id;
        this.visited = visited;
    }

}
