package oldstudy.graphsbook;

class Line {

    private int weight;
    private boolean visited;
    private GraphNod src;
    private GraphNod dest;

    public Line(int weight, boolean visited, GraphNod src,
                GraphNod dest) {
        this.weight = weight;
        this.visited = visited;
        this.src = src;
        this.dest = dest;
    }

    int getWeight() {
        return weight;
    }

    void setWeight(int weight) {
        this.weight = weight;
    }

    boolean isVisited() {
        return visited;
    }

    void setVisited(boolean visited) {
        this.visited = visited;
    }

    GraphNod getSrc() {
        return src;
    }

    void setSrc(GraphNod src) {
        this.src = src;
    }

    GraphNod getDest() {
        return dest;
    }

    void setDest(GraphNod dest) {
        this.dest = dest;
    }
}