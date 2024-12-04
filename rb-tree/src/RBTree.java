public class RBTree {
    private Node root;

    public Node insert(int key) {
        Node node = new Node(key);
        if (root == null) {
            root = node;
            root.setColor("black");
        } else {
            Node control = root;
            while (control != null) {
                if (key > control.getKey()) {
                    if (control.getRight() == null) {
                        control.setRight(node);
                        node.setParent(control);
                        insertFix(node);
                        return node;
                    }
                    control = control.getRight();
                } else if (key < control.getKey()) {
                    if (control.getLeft() == null) {
                        control.setLeft(node);
                        node.setParent(control);
                        insertFix(node);
                        return node;
                    }
                    control = control.getLeft();
                }
            }
        }
        return node;
    }

    private void insertFix(Node node) {
        Node control = node;
        while (control != root && control != null) {
            Node pai = control.getParent();
            Node avo = control.getParent().getParent();
            Node tio = null;
            if (pai != null && avo != null && avo.getRight() == pai) {
                tio = avo.getLeft();
            } else if ((pai != null && avo != null && avo.getLeft() == pai)) {
                tio = avo.getRight();
            }

            // Caso 2
            if (control.getColor() == "red" && (pai != null && pai.getColor() == "red")
                    && (tio != null && tio.getColor() == "red") && avo != null) {
                pai.setColor("black");
                tio.setColor("black");
                avo.setColor("red");
                root.setColor("black");
            }

            // Caso 3
            if (control.getColor() == "red" && (pai != null && pai.getColor() == "red")
                    && (tio == null || tio.getColor() != "red")) {
                if (pai == avo.getRight()) {
                    if (control == pai.getRight()) {
                        leftRotate(control.getParent());
                    } else {
                        rightRotate(control);
                        leftRotate(control);
                    }
                } else {
                    if (control == pai.getLeft()) {
                        rightRotate(pai);
                    } else {
                        leftRotate(control);
                        rightRotate(control);
                    }
                }
            }
            while (root.getParent() != null) {
                root = root.getParent();
            }

            control = control.getParent();
        }

    }

    public Node remove(int key) throws FlamengoException {
        Node node = root;

        if (root != null) {
            while (node != null) {
                if (key == node.getKey()) {
                    System.out.println("Remove:" + node.getKey());
                    System.out.println();
                    Node r = node;
                    Node successor = null;

                    // Nó removido é folha
                    if (node.getLeft() == null && node.getRight() == null) {
                        if (node == node.getParent().getRight()) {
                            node.getParent().setRight(null);
                        } else {
                            node.getParent().setLeft(null);
                        }
                    }

                    // Nó removido possui um filho
                    else if (node.getLeft() == null) {
                        if (node.getParent() != null) {
                            successor = node.getRight();
                            if (node == node.getParent().getRight()) {
                                node.getParent().setRight(node.getRight());
                            } else {
                                node.getParent().setLeft(node.getRight());
                            }
                        } else {
                            root = node.getRight();
                        }
                        node.getRight().setParent(node.getParent());
                    } else if (node.getRight() == null) {
                        if (node.getParent() != null) {
                            successor = node.getLeft();
                            if (node == node.getParent().getRight()) {
                                node.getParent().setRight(node.getLeft());
                            } else {
                                node.getParent().setLeft(node.getLeft());
                            }
                        } else {
                            root = node.getLeft();
                        }
                        node.getLeft().setParent(node.getParent());
                    }

                    // Nó removido possui dois filhos
                    else {
                        successor = node.getRight();
                        while (successor.getLeft() != null) {
                            successor = successor.getLeft();
                        }
                        node.setKey(successor.getKey());

                        if (successor == successor.getParent().getRight()) {
                            successor.getParent().setRight(successor.getRight());
                        } else {
                            successor.getParent().setLeft(successor.getRight());
                        }
                        if (successor.getRight() != null) {
                            successor.getRight().setParent(successor.getParent());
                        }
                    }

                    if (node.getColor() == "red" && successor == null) {
                        System.out.println("Caso 1! Uhuuuu!");
                    } else if (node.getColor() == "black" && successor != null && successor.getColor() == "red") {
                        System.out.println("Caso 2");
                    }

                    else if (node.getColor() == "black" && successor == null
                            || node.getColor() == "black" && successor.getColor() == "black") {
                        System.out.println("Se ferrou");
                    }

                    return r;
                }
                if (key > node.getKey()) {
                    node = node.getRight();
                } else if (key < node.getKey()) {
                    node = node.getLeft();
                }
            }
        } else {
            throw new FlamengoException("Empty Tree");
        }

        return node;
    }

    // private Node findSuccessor(Node node) {
    // Node successor = node.getRight();

    // }

    private Node leftRotate(Node b) {
        Node a = b.getParent();
        b.setParent(a.getParent());
        if (a.getParent() != null) {
            if (a.getParent().getRight() == a) {
                a.getParent().setRight(b);
            } else {
                a.getParent().setLeft(b);
            }
        }
        a.setParent(b);
        a.setRight(b.getLeft());
        b.setLeft(a);
        b.setColor("black");
        a.setColor("red");
        return b;
    }

    private Node rightRotate(Node b) {
        Node a = b.getParent();
        b.setParent(a.getParent());
        if (a.getParent() != null) {
            if (a.getParent().getRight() == a) {
                a.getParent().setRight(b);
            } else {
                a.getParent().setLeft(b);
            }
        }
        a.setParent(b);
        a.setLeft(b.getRight());
        b.setRight(a);
        b.setColor("black");
        a.setColor("red");
        return a;
    }

    public void show() {
        printTree(root, 0);
        System.out.println();
    }

    private void printTree(Node node, int level) {
        if (node == null) {
            return;
        }

        // Imprime o lado direito primeiro (de forma recursiva)
        printTree(node.getRight(), level + 1);

        // Imprime o nó atual com deslocamento
        if (node.getColor() == "red") {
            System.out.println(" ".repeat(level * 4) + "\u001B[31m" + node.getKey() + "\u001B[0m");
        } else {
            System.out.println(" ".repeat(level * 4) + node.getKey());
        }

        // Imprime o lado esquerdo (de forma recursiva)
        printTree(node.getLeft(), level + 1);
    }
}
