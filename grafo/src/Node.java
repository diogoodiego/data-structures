import java.util.ArrayList;

public class Node {
    private String node;
    private ArrayList<Edge> edges;

    public Node() {
        this.node = null;
    }

    public Node(String node) {
        this.node = node;
        this.edges = new ArrayList<Edge>();
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public Integer size() {
        return edges.size();
    }

}
