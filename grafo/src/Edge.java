public class Edge {
    private Integer custo;
    private Node node;

    public Edge(Integer custo, Node node) {
        this.custo = custo;
        this.node = node;
    }

    public void setCusto(Integer custo) {
        this.custo = custo;
    }

    public Integer getCusto() {
        return custo;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public Node getNode() {
        return node;
    }
}
