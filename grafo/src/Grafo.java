import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class Grafo {
    private Object m[][];
    private int vertices;
    private Graph graphStream;

    public Grafo() {
        this.m = null;
        this.vertices = 0;
        System.setProperty("org.graphstream.ui", "swing");
        this.graphStream = new SingleGraph("Exemplo de Grafo");

    }

    public String addVertice(String v) {
        if (this.m == null) {
            this.m = new Object[2][2];
        }
        m[0][vertices + 1] = v;
        m[vertices + 1][0] = v;
        vertices++;
        Show();
        Resize();
        graphStream.addNode(v).setAttribute("label", v);
        return v;
    }

    public String addEdge(String v1, String v2, String a) {
        if (this.m == null) {
            // Error
        }
        int positonV1 = 0, positonV2 = 0;

        for (int i = 0; i <= vertices; i++) {
            if (m[0][i] == v1) {
                positonV1 = i;
            }
            if (m[0][i] == v2) {
                positonV2 = i;
            }
            if (positonV1 != 0 && positonV2 != 0) {
                break;
            }
        }
        m[positonV1][positonV2] = a;
        Show();
        graphStream.addEdge(a, v1, v2).setAttribute("label", a);
        return a;
    }

    public void Resize() {
        Object[][] nM = new Object[vertices + 2][vertices + 2];
        for (int i = 0; i <= vertices; i++) {
            for (int j = 0; j <= vertices; j++) {
                nM[i][j] = m[i][j];
            }
        }
        m = nM;
    }

    private void Show() {
        if (m != null) {
            for (int i = 0; i <= vertices; i++) {
                for (int j = 0; j <= vertices; j++) {
                    if (m[i][j] != null) {
                        System.out.printf("%-30s", m[i][j]);
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

    public void Display() {
        graphStream.display();
    }
}
