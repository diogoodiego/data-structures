import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class GrafoDirecionado {
    private Object matriz[][];
    private int vertices;
    private Graph graphStream;

    public GrafoDirecionado() {
        this.matriz = null;
        this.vertices = 0;
        System.setProperty("org.graphstream.ui", "swing");
        this.graphStream = new SingleGraph("Exemplo de Grafo");
    }

    public String AddNode(String node) {
        if (matriz == null) {
            matriz = new Object[2][];
            matriz[0] = new Object[1];
            matriz[1] = new Object[2];
        }
        vertices++;
        matriz[vertices][0] = node;
        resize();
        graphStream.addNode(node).setAttribute("label", node);
        return node;
    }

    public String addEdge(String edge, String nodeA, String nodeB) {
        int v1 = 0, v2 = 0;
        for (int i = 0; i <= vertices; i++) {
            if (matriz[i][0] == nodeA) {
                v1 = i;
            } else if (matriz[i][0] == nodeB) {
                v2 = i;
            }
            if (v1 != 0 && v2 != 0) {
                break;
            }
        }
        if (v1 < v2) {
            matriz[v2][v1] = edge;
        } else {
            matriz[v1][v2] = edge;
        }
        graphStream.addEdge(edge, nodeA, nodeB, true).setAttribute("label", edge);
        return edge;
    }

    private void resize() {
        Object[][] matrizB = new Object[vertices + 2][];
        for (int i = 0; i <= vertices + 1; i++) {
            matrizB[i] = new Object[i + 1];
        }

        for (int i = 0; i < vertices + 1; i++) {
            for (int j = 0; j <= i; j++) {
                matrizB[i][j] = matriz[i][j];
            }
        }
        // for (int i = 0; i <= vertices; i++) {
        // for (int j = 0; j <= vertices; j++) {
        // matrizB[i][j] = matriz[i][j];
        // }
        // }
        matriz = matrizB;
    }

    public void Display() {
        graphStream.display();
    }

    public void Show() {
        if (matriz != null) {
            for (int i = 0; i <= vertices + 1; i++) {
                for (int j = 0; j <= i; j++) {
                    if (matriz[i][j] != null) {
                        System.out.printf("%-30s", matriz[i][j]);
                    } else {
                        System.out.printf("%-30s", "0");
                    }
                }
                System.out.println();
            }
            System.out.println("______________________________________________________________");
            System.out.println();
        }
    }
}
