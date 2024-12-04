public class Node {
    private int key;
    private int fb;
    private Node parent;
    private Node left;
    private Node right;

    public Node() {
        this.key = 0;
        this.fb = 0;
        left = right = null;
    }

    public Node(int key) {
        this.key = key;
        this.fb = 0;
        left = right = null;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getFb() {
        return fb;
    }

    public void setFb(int fb) {
        this.fb = fb;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
