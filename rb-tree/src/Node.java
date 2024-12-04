public class Node {
    private Node left;
    private Node right;
    private Node parent;
    private int key;
    private String color;

    public Node() {
        this.key = 0;
        this.color = "red";
        left = right = null;
    }

    public Node(int key) {
        this.key = key;
        this.color = "red";
        left = right = null;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public Node getParent() {
        return parent;
    }

    public int getKey() {
        return key;
    }

    public String getColor() {
        return color;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setColor(String color) {
        this.color = color;
    }
}