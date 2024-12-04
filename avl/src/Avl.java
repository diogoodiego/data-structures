public class Avl {
    private Node root;

    public Avl() {
        root = null;
    }

    public Node insert(int key) {
        Node node = new Node(key);
        if (root == null) {
            root = node;
            return node;
        }
        Node x = new Node();
        x = root;
        while (x != null) {
            if (key > x.getKey()) {
                if (x.getRight() == null) {
                    x.setRight(node);
                    node.setParent(x);
                    rebalancing(node);
                    return node;
                }
                x = x.getRight();
            } else if (key < x.getKey()) {
                if (x.getLeft() == null) {
                    x.setLeft(node);
                    node.setParent(x);
                    rebalancing(node);
                    return node;
                }
                x = x.getLeft();
            }
        }
        return node;
    }

    public void rebalancing(Node node) {
        int control = 0;
        Node a = node;

        while (control == 0) {
            if (a.getParent().getRight() == a) {
                a.getParent().setFb(a.getParent().getFb() - 1);
            } else {
                a.getParent().setFb(a.getParent().getFb() + 1);
            }
            if (a.getParent().getFb() > 1 || a.getParent().getFb() < -1) {
                a = rotate(a.getParent());
                if (a.getFb() == 0) {
                    control = 1;
                }
            } else if (a.getParent().getFb() == 0) {
                control = 1;
            } else {
                a = a.getParent();
            }

            if (a.getParent() == null) {
                control = 1;
            }
        }
        while (this.root.getParent() != null) {
            root = root.getParent();
        }
    }

    public Node remove(int key) {
        Node node = root;
        while (node != null) {
            if (node.getKey() == key) {
                // Remove
                Node r = node;
                // Caso: Node tem apenas um filho
                if (node.getLeft() == null && node.getRight() == null) {
                    removeRebalance(node);
                    if (node.getParent().getRight() == node) {
                        node.getParent().setRight(null);
                    } else {
                        node.getParent().setLeft(null);
                    }
                }
                if (node.getLeft() == null && node.getRight() != null) {
                    // Verifica se node é filho direito
                    removeRebalance(node);
                    if (node.getParent() != null && node.getParent().getRight() == node) {
                        node.getParent().setRight(node.getRight());
                    } else {
                        node.getParent().setLeft(node.getRight());
                    }
                    node.getRight().setParent(node.getParent());
                    node = null;
                } else if (node.getLeft() != null && node.getRight() == null) {
                    removeRebalance(node);
                    // Verifica se node é filho direito
                    if (node.getParent() != null && node.getParent().getRight() == node) {
                        node.getParent().setRight(node.getLeft());
                    } else {
                        node.getParent().setLeft(node.getLeft());
                    }
                    node.getLeft().setParent(node.getParent());
                    node = null;
                } else if (node.getRight() != null && node.getLeft() != null) {
                    Node sucessor = node.getRight();
                    while (sucessor.getLeft() != null) {
                        sucessor = sucessor.getLeft();
                    }
                    removeRebalance(sucessor);
                    node.setKey(sucessor.getKey());
                    sucessor.getParent().setLeft(null);
                }
                return r;

            } else if (key > node.getKey()) {
                node = node.getRight();
            } else {
                node = node.getLeft();
            }
        }
        return node;

    }

    private void removeRebalance(Node node) {
        do {
            if (node.getParent().getRight() == node) {
                node.getParent().setFb(node.getParent().getFb() + 1);
            } else {
                node.getParent().setFb(node.getParent().getFb() - 1);
            }
            node = node.getParent();
            if (node != null && node.getFb() > 1 || node != null && node.getFb() < -1) {
                node = rotate(node);
            }

        } while (node.getParent() != null && node.getFb() == 0);
        while (root.getParent() != null) {
            root = root.getParent();
        }
    }

    public Node rotate(Node b) {
        // Rotação simples esquerda
        if (b.getFb() < -1 && b.getRight().getFb() <= 0) {
            return rotateLeft(b);
        } else if (b.getFb() > 1 && b.getLeft().getFb() >= 0) {
            return rotateRight(b);
        } else if (b.getFb() > 1 && b.getLeft().getFb() < 0) {
            rotateLeft(b.getLeft());
            return rotateRight(b);
        } else if (b.getFb() < -1 && b.getRight().getFb() > 0) {
            rotateRight(b.getRight());
            return rotateLeft(b);
        }
        return b;
    }

    public Node rotateLeft(Node b) {
        Node a = b.getRight();
        int fb_a = 0;
        int fb_b = 0;
        if (b.getParent() != null) {
            if (b.getParent().getLeft() == b) {
                b.getParent().setLeft(a);
            } else {
                b.getParent().setRight(a);
            }
        }
        a.setParent(b.getParent());
        b.setParent(a);
        if (a.getLeft() != null) {
            b.setRight(a.getLeft());
            a.getLeft().setParent(b);
        } else {
            b.setRight(null);
        }
        a.setLeft(b);
        fb_b = b.getFb() + 1 - Math.min(a.getFb(), 0);
        fb_a = a.getFb() + 1 + Math.max(fb_b, 0);
        b.setFb(fb_b);
        a.setFb(fb_a);
        return a;
    }

    public Node rotateRight(Node b) {
        Node a = b.getLeft();
        int fb_a = 0;
        int fb_b = 0;
        if (b.getParent() != null) {
            if (b.getParent().getLeft() == b) {
                b.getParent().setLeft(a);
            } else {
                b.getParent().setRight(a);
            }
        }
        a.setParent(b.getParent());
        b.setParent(a);
        if (a.getRight() != null) {
            b.setLeft(a.getRight());
            a.getRight().setParent(b);
        } else {
            b.setLeft(null);
        }
        a.setRight(b);
        fb_b = b.getFb() - 1 - Math.max(a.getFb(), 0);
        fb_a = a.getFb() - 1 + Math.min(fb_b, 0);
        b.setFb(fb_b);
        a.setFb(fb_a);
        return a;
    }

    public int Heigth() {
        return HeigthAux(this.root);
    }

    private int HeigthAux(Node node) {
        if (node == null || (node.getLeft() == null &&
                node.getRight() == null)) {
            return 0;
        } else {
            if (HeigthAux(node.getLeft()) > HeigthAux(node.getRight())) {
                return 1 + HeigthAux(node.getLeft());
            } else {
                return 1 + HeigthAux(node.getRight());
            }
        }
    }

    public void Show() {
        int col = 1;
        for (int i = 0; i <= (Heigth() * 1); i++) {
            col = col * 2;
        }
        int row = Heigth() * 4;
        Node map[][] = new Node[col][row];
        ShowAux(this.root, map, col / 2, 0, col / 4, 2);
        for (int i = 0; i < (col + 2); i++) {
            System.out.printf("%-4s", "__");
        }
        System.out.println("");

        for (int i = 0; i < row; i++) {
            System.out.print("| ");
            for (int j = 0; j < col; j++) {
                if (map[j][i] != null) {
                    System.out.printf("%-6s", map[j][i].getKey() + "[" + map[j][i].getFb() + "]");
                } else {
                    System.out.printf("%-6s", " ");
                }
            }
            System.out.println("");
        }
        for (int i = 0; i < (col + 2); i++) {
            System.out.print("__");
        }
        System.out.println("");
    }

    private void ShowAux(Node node, Node[][] map, int x, int y, int xIncrease,
            int yIncrease) {
        map[x][y] = node;
        if (node.getLeft() != null) {
            ShowAux(node.getLeft(), map, x - xIncrease, y + yIncrease,
                    xIncrease / 2, yIncrease);
        }
        if (node.getRight() != null) {
            ShowAux(node.getRight(), map, x + xIncrease, y + yIncrease,
                    xIncrease / 2, yIncrease);
        }
    }
}
